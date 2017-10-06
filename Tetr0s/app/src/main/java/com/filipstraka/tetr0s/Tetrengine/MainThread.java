package com.filipstraka.tetr0s.Tetrengine;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

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
        //RUN
        //Poziva se 60 puta u sekundi (tako bi trebalo ako nisam nista za-j...)





        //###########REGULACIJA FRAMOVA###########
        long startTime;
        long timeMilis = 1000/MAX_FPS;
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000/MAX_FPS;

        while (running){
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
            }
            finally {
                if(canvas != null){
                    try{
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
            if(frameCount == MAX_FPS){
                avgFPS = 1000/(totalTime/frameCount)/1000000;
                frameCount = 0;
            }
        }

        //########KRAJ REGULACIJE FRAMOVA############


    }
}
