package com.filipstraka.tetr0s.Tetrengine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by strak on 3.10.2017..
 */

public class Tetrengine extends SurfaceView implements SurfaceHolder.Callback{
    MainThread thread;
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
        return super.onTouchEvent(event);

    }
    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
    }
}
