package com.filipstraka.tetr0s.Tetrengine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.filipstraka.tetr0s.MainActivity;
import com.filipstraka.tetr0s.R;

/**
 * Created by strak on 3.10.2017..
 */

public class Tetrengine extends SurfaceView implements SurfaceHolder.Callback{
    MainThread thread;
    PlayerThread playerThread;

    int canvasHeight, canvasWidth, gridHeight, gridWidth, blockSide;
    Bitmap blue,cyan,green,magenta,orange,red,yellow;
    Bitmap move_left, move_right, move_down, rotate_left, rotate_right;
    int buttonSize;
    Rect leftRect, rightRect, downRect, rotateLeftRect, rotateRightRect;

    Vibrator vibrator;

    SoundPool soundPool;
    SoundPool.Builder soundPoolBuilder;

    AudioAttributes audioAttributes;
    AudioAttributes.Builder audioAttributesBuilder;
    int soundID_move, soundID_drop;

    double gridX = 3.5;
    double gridY = 1;
    /*
    * #####10x22 ORIGINAL TETRIS MATRICA#####
    * #####RED 0 I 1 SE NE RENDERUJU######
    * 1 - I (CYAN)
    * 2 - O (ZUTA)
    * 3 - T (MAGENTA)
    * 4 - S (ZELENA)
    * 5 - Z (CRVENA)
    * 6 - J (PLAVA)
    * 7 - L (NARANDZASTA)
    */
    //Matrica blokova
    public Block[][] Map = new Block[10][22]; //Block [levo/desno(x)]  [gore/dole(y)]

    @SuppressLint("NewApi")
    public Tetrengine(Context context, Vibrator vib) {
        super(context);
        vibrator = vib;
        getHolder().addCallback(this);
        setFocusable(true);
        thread = new MainThread(getHolder(), this);
        
        audioAttributesBuilder = new AudioAttributes.Builder();
        audioAttributesBuilder.setUsage(AudioAttributes.USAGE_GAME);
        audioAttributesBuilder.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION);
        audioAttributes = audioAttributesBuilder.build();

        soundPoolBuilder = new SoundPool.Builder();
        soundPoolBuilder.setAudioAttributes(audioAttributes);
        soundPool = soundPoolBuilder.build();

        soundID_drop = soundPool.load(context, R.raw.sound_drop, 1);
        soundID_move = soundPool.load(context, R.raw.sound_move, 1);
    }


    public void update(){

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //Ucitavanje Textura
        blue = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.block_blue);
        cyan = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.block_cyan);
        green = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.block_green);
        magenta = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.block_magenta);
        orange = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.block_orange);
        red = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.block_red);
        yellow = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.block_yellow);
        move_left = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.left);
        move_right = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.right);
        move_down = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.down);
        rotate_left = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.rotate_left);
        rotate_right = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.rotate_right);

        //RELATIVNE KALKULACIJE SAMO DA BUDE U ODNOSIMA NE U PIXELIMA
        //DA BI RADILO I NA DRUGIM REZOLUCIJAMA I OSTALIM UREDJAJIMA
        canvasHeight = holder.getSurfaceFrame().height();
        canvasWidth = holder.getSurfaceFrame().width();
        gridWidth = (canvasWidth /5)*3;
        blockSide = gridWidth/10;
        gridHeight = blockSide*20;
        buttonSize = blockSide*3;
        Log.e("HEIGHT x WIDTH", ""+canvasWidth + " x "+canvasHeight);

        //INICIJALIZACIJA SVIH BLOKOVA I PODESAVANJE BOJE NA BELO (null)
        for(int i=0; i < 22; i++){
            for(int j=0; j < 10; j++){
                Map[j][i] = new Block((int)(gridX*blockSide+j*blockSide), (int)(gridY*blockSide+(i-2)*blockSide), null, blockSide);
            }
        }
        //Inicijalizacija i Startovanje glavnog thread-a
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();

        //Inicijalizacija i Startovanje player thread-a
        playerThread = new PlayerThread(this);
        playerThread.setRunning(true);
        playerThread.setDelay(800); //milisekunde (ostavite .8s za sada)
        playerThread.start();

        //Inicijalizacija Rectova
        rotateRightRect = new Rect(canvasWidth-2-buttonSize,gridHeight, canvasWidth-2, gridHeight+buttonSize);
        rotateLeftRect = new Rect(2,gridHeight, 2+buttonSize, gridHeight+buttonSize);
        downRect = new Rect((int)gridX*blockSide+(int)(gridWidth*1.08)/2-buttonSize/2, (int)gridY*blockSide+gridHeight+10+(int)(blockSide*2.5), (int)gridX*blockSide+(int)(gridWidth*1.08)/2+buttonSize/2, (int)gridY*blockSide+gridHeight+10+buttonSize+(int)(blockSide*2.5));
        rightRect = new Rect((int)gridX*blockSide+(int)(gridWidth*1.08)-buttonSize, (int)gridY*blockSide+gridHeight+10, (int)gridX*blockSide+(int)(gridWidth*1.08), (int)gridY*blockSide+gridHeight+10+buttonSize);
        leftRect = new Rect((int)gridX*blockSide, (int)gridY*blockSide+gridHeight+10, (int)gridX*blockSide+buttonSize, (int)gridY*blockSide+gridHeight+10+buttonSize);
    }
    public boolean checkFullRow(int row){
        for(int i = 0; i < 10; i++){
            if(Map[i][row].bitmap == null){
                return false;
            }
        }
        return true;
    }
    public void clearRow(int row){
        for(int i = 0; i < 10; i++) {
            for(int j = row; j > 0; j--) {
                Map[i][j].setBitmap(Map[i][j-1].bitmap);
            }
        }
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent (MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(leftRect.contains((int)event.getX(), (int)event.getY())) {
                    Log.d("Input", "LEFT");
                     //Left
                    playerThread.moveLeft();
                    vibrator.vibrate(70);

                }
                if(rightRect.contains((int)event.getX(), (int)event.getY())) {
                    Log.d("Input", "RIGHT");
                    //Right
                    playerThread.moveRight();
                    vibrator.vibrate(70);

                }
                if(downRect.contains((int)event.getX(), (int)event.getY())) {
                    Log.d("Input", "DOWN");
                    //Down
                    playerThread.drop();
                    vibrator.vibrate(70);
                }
                if(rotateLeftRect.contains((int)event.getX(), (int)event.getY())) {
                    Log.d("Input", "ROTATE_LEFT");
                    //Rotate Left
                    vibrator.vibrate(70);
                }
                if(rotateRightRect.contains((int)event.getX(), (int)event.getY())) {
                    Log.d("Input", "ROTATE_RIGHT");
                    //Rotate Right
                    vibrator.vibrate(70);

                }


            case MotionEvent.ACTION_UP:
                if(downRect.contains((int)event.getX(), (int)event.getY())) {
                    //playerThread.setDelay(800);
                }
        }
        return true;
        //return super.onTouchEvent(event);
    }
    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);

        //UPDATUJE BLOKOVE
        for(int i=2; i < 22; i++){
            for(int j=0; j < 10; j++){
               Map[j][i].draw(canvas);
            }
        }
        //BORDER
        Paint paint = new Paint();
        float leftx = (float)(gridX) * blockSide;
        float topy = (float)(gridY) * blockSide;
        float rightx = (float)(gridX) * blockSide+gridWidth;
        float bottomy = (float)(gridY) * blockSide+gridHeight;
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(leftx, topy, rightx, bottomy, paint);

        //BUTTONS
        canvas.drawBitmap(move_left, null, leftRect, null);
        canvas.drawBitmap(move_right, null, rightRect, null);
        canvas.drawBitmap(move_down, null, downRect, null);
        canvas.drawBitmap(rotate_left, null, rotateLeftRect, null);
        canvas.drawBitmap(rotate_right, null, rotateRightRect, null);
    }
}
