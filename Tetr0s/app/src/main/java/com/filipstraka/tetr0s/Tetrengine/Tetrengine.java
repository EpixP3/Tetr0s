package com.filipstraka.tetr0s.Tetrengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.filipstraka.tetr0s.R;

/**
 * Created by strak on 3.10.2017..
 */

public class Tetrengine extends SurfaceView implements SurfaceHolder.Callback{
    MainThread thread;
    PlayerThread playerThread;
    int canvasHeight, canvasWidth, gridHeight, gridWidth, blockSide;
    Bitmap blue,cyan,green,magenta,orange,red,yellow;

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
    public Block[][] Map = new Block[10][22];

    public Tetrengine(Context context){
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        thread = new MainThread(getHolder(), this);
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

        //RELATIVNE KALKULACIJE SAMO DA BUDE U ODNOSIMA NE U PIXELIMA
        //DA BI RADILO I NA DRUGIM REZOLUCIJAMA I OSTALIM UREDJAJIMA
        canvasHeight = holder.getSurfaceFrame().height();
        canvasWidth = holder.getSurfaceFrame().width();
        gridWidth = (canvasWidth /5)*3;
        blockSide = gridWidth/10;
        gridHeight = blockSide*20;
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
        playerThread.setDelay(800); //milisekunde
        playerThread.start();
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
    @Override
    public boolean onTouchEvent (MotionEvent event){

        return true;
        //return super.onTouchEvent(event);
    }
    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
       // canvas.drawColor(Color.WHITE);




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
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(leftx, topy, rightx, bottomy, paint);


    }
}
