package com.filipstraka.tetr0s.Tetrengine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by strak on 5.10.2017..
 */

public class Block implements Object {
    Point point;
    int color;
    Rect rect = new Rect();

    public Block(Point point, int color, int size){
        this.point = point;
        this.color = color;
        rect.set(point.x, point.y, point.x+size, point.y+size);
    }
    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rect, paint);
    }
    @Override
    public void update() {
    }
    public void update(Point point, int size){
        this.point = point;
        rect.set(point.x, point.y, point.x+size, point.y+size);
    }
}
