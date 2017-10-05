package com.filipstraka.tetr0s.Tetrengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.filipstraka.tetr0s.R;

/**
 * Created by strak on 5.10.2017..
 */

public class Block implements Object {
    Point point;
    int color;
    Rect rect = new Rect();
    Bitmap blue,cyan,green,magenta,orange,red,yellow;

    public Block(Point point, int color, int size, Context context){
        this.point = point;
        this.color = color;
        rect.set(point.x, point.y, point.x+size, point.y+size);
        blue = BitmapFactory.decodeResource(context.getResources(), R.drawable.block_blue);
        cyan = BitmapFactory.decodeResource(context.getResources(), R.drawable.block_cyan);
        green = BitmapFactory.decodeResource(context.getResources(), R.drawable.block_green);
        magenta = BitmapFactory.decodeResource(context.getResources(), R.drawable.block_magenta);
        orange = BitmapFactory.decodeResource(context.getResources(), R.drawable.block_orange);
        red = BitmapFactory.decodeResource(context.getResources(), R.drawable.block_red);
        yellow = BitmapFactory.decodeResource(context.getResources(), R.drawable.block_yellow);
    }
    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        //paint.setColor(color);
        //canvas.drawRect(rect, paint);
        if(color == Color.BLUE){
            canvas.drawBitmap(blue, null, rect, paint);
        }
        else if(color == Color.RED) {
            canvas.drawBitmap(red, null, rect, paint);
        }
        else if(color == Color.CYAN) {
            canvas.drawBitmap(cyan, null, rect, paint);
        }
        else if(color == Color.GREEN) {
            canvas.drawBitmap(green, null, rect, paint);
        }
        else if(color == Color.MAGENTA) {
            canvas.drawBitmap(magenta, null, rect, paint);
        }
        else if(color == Color.rgb(255, 127, 0)) {
            canvas.drawBitmap(orange, null, rect, paint);
        }
        else if(color == Color.YELLOW) {
            canvas.drawBitmap(yellow, null, rect, paint);
        }
    }
    @Override
    public void update() {
    }
    public void update(Point point, int size){
        this.point = point;
        rect.set(point.x, point.y, point.x+size, point.y+size);
    }
}
