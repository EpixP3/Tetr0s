package com.filipstraka.tetr0s.Tetrengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.filipstraka.tetr0s.R;

/**
 * Created by strak on 5.10.2017..
 */

public class Block implements Object {
    Point point;
    Rect rect = new Rect();
    Bitmap bitmap;
    Tetrengine tetrengine;
    int mapX, mapY;

    //konstruktor za inicijalizaciju bloka
    public Block(int x, int y, Bitmap newBitmap, int size){
        this.point = new Point(x, y);
        this.bitmap = newBitmap;
        rect.set(point.x, point.y, point.x+size, point.y+size);
    }

    //da mozemo lako da podesimo boju
    public void setBitmap(Bitmap newBitmap){
        this.bitmap = newBitmap;
    }

    //ovo ne moram da komentarisem..
    @Override
    public void draw(Canvas canvas) {
        //ako je polje prazno onda koji k cu da crtam...
        if(bitmap != null) {
            Paint paint = new Paint();
            canvas.drawBitmap(bitmap, null, rect, paint);
        }
    }
}
