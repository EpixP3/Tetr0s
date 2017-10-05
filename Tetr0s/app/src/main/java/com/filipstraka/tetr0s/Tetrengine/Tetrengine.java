package com.filipstraka.tetr0s.Tetrengine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by strak on 3.10.2017..
 */

public class Tetrengine extends SurfaceView implements SurfaceHolder.Callback{
    MainThread thread;
    int canvasHeight, canvasWidth, gridHeight, gridWidth, blockSide;
    double gridX = 3.5;
    double gridY = 1;
    /*
    * #####10x22 ORIGINAL TETRIS MATRICA#####
    * #####RED 0 I 1 SE NE RENDERUJU######
    * 0 - PRAZNO POLJE
    * 1 - I (CYAN)
    * 2 - O (ZUTA)
    * 3 - T (MAGENTA)
    * 4 - S (ZELENA)
    * 5 - Z (CRVENA)
    * 6 - J (PLAVA)
    * 7 - L (NARANDZASTA)
     */
    public int[][] Map = {{0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {1,1,2,3,4,5,6,7,0,1},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {1,0,0,0,0,0,0,0,0,1}};

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
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
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
        canvas.drawColor(Color.WHITE);

        //RELATIVNE KALKULACIJE SAMO DA BUDE U ODNOSIMA NE U PIXELIMA
        //DA BI RADILO I NA DRUGIM REZOLUCIJAMA I OSTALIM UREDJAJIMA
        canvasHeight = canvas.getHeight();
        canvasWidth = canvas.getWidth();
        gridWidth = (canvasWidth /5)*3;
        blockSide = gridWidth/10;
        gridHeight = blockSide*20;



        //UPDATUJE BLOKOVE
        for(int i=2; i < 22; i++){
            for(int j=0; j < 10; j++){

                if(Map[i][j] == 1){
                    new Block(new Point((int)(gridX*blockSide+j*blockSide), (int)(gridY*blockSide+(i-2)*blockSide)), Color.CYAN, blockSide, getContext()).draw(canvas);
                }
                else if(Map[i][j] == 2){
                    new Block(new Point((int)(gridX*blockSide+j*blockSide), (int)(gridY*blockSide+(i-2)*blockSide)), Color.YELLOW, blockSide, getContext()).draw(canvas);
                }
                else if(Map[i][j] == 3){
                    new Block(new Point((int)(gridX*blockSide+j*blockSide), (int)(gridY*blockSide+(i-2)*blockSide)), Color.MAGENTA, blockSide, getContext()).draw(canvas);
                }
                else if(Map[i][j] == 4){
                    new Block(new Point((int)(gridX*blockSide+j*blockSide), (int)(gridY*blockSide+(i-2)*blockSide)), Color.GREEN, blockSide, getContext()).draw(canvas);
                }
                else if(Map[i][j] == 5){
                    new Block(new Point((int)(gridX*blockSide+j*blockSide), (int)(gridY*blockSide+(i-2)*blockSide)), Color.RED, blockSide, getContext()).draw(canvas);
                }
                else if(Map[i][j] == 6){
                    new Block(new Point((int)(gridX*blockSide+j*blockSide), (int)(gridY*blockSide+(i-2)*blockSide)), Color.BLUE, blockSide, getContext()).draw(canvas);
                }
                else if(Map[i][j] == 7){
                    new Block(new Point((int)(gridX*blockSide+j*blockSide), (int)(gridY*blockSide+(i-2)*blockSide)), Color.rgb(255, 127, 0), blockSide, getContext()).draw(canvas);
                }
                else{
                    new Block(new Point((int)(gridX*blockSide+j*blockSide), (int)(gridY*blockSide+(i-2)*blockSide)), Color.WHITE, blockSide, getContext()).draw(canvas);
                }
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


    }
}
