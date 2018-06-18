package com.filipstraka.tetr0s.Tetrengine;

import android.app.Application;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

import com.filipstraka.tetr0s.MainActivity;

/**
 * Created by strak on 4.10.2017..
 */

public class MainThread extends Thread {
    public static final int MAX_FPS = 60;
    private double avgFPS;
    private SurfaceHolder holder;
    private Tetrengine tetrengine;
    private boolean running;
    public static Canvas canvas;

    public MainThread (SurfaceHolder holder, Tetrengine tetrengine){
        super();
        this.holder = holder;
        this.tetrengine = tetrengine;
    }

    public void setRunning(boolean running){
        this.running = running;
    }

    @Override
    public void run(){
        long startTime;
        long timeMilis = 1000/MAX_FPS;
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000/MAX_FPS;

        while (running){
            //60 PUTA U SEKUNDI SE IZVRSI OVAJ KOD ISPOD

            //nema koda

            //60 PUTA U SEKUNDI SE IZVRSI OVAJ KOD IZNAD
            //###### REGULACIJA FRAMOVA ##########################################
            startTime = System.nanoTime();
            canvas = null;
            try{

                canvas = this.holder.lockCanvas();
                synchronized (holder){
                    this.tetrengine.update();
                    this.tetrengine.draw(canvas);
                }
            }
            catch (Exception e){
                e.printStackTrace();
                try {
                    this.holder.unlockCanvasAndPost(canvas);
                }catch(Exception el){
                    //User je vrv izasao iz igre
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
            }
            finally {
                if(canvas != null){
                    try{
                        Paint txtpaint = new Paint();
                        txtpaint.setTextSize(20);
                        txtpaint.setColor(Color.RED);
                        txtpaint.setStrokeWidth(1);
                        txtpaint.setShadowLayer(1, 1,1,Color.BLACK);
                        txtpaint.setFakeBoldText(true);
                        canvas.drawText("Frame: "+frameCount, 10, 20, txtpaint);
                        holder.unlockCanvasAndPost(canvas);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            timeMilis = (System.nanoTime() - startTime)/1000000;
            waitTime = targetTime - timeMilis;
            try{
                if (waitTime > 0){
                    this.sleep(waitTime);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if(frameCount == MAX_FPS) {
                //avgFPS = 1000 / (totalTime/MAX_FPS) / 1000000;
                avgFPS = 1000/(totalTime/MAX_FPS);
                frameCount=0;
            }
            //###### KRAJ REGULACIJE FRAMOVA#############################################
        }
    }
}
