package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class game extends SurfaceView implements SurfaceHolder.Callback{

    private Paint Paint;

    public game(Context context) {
        super(context);
        Canvas canvas = new Canvas();
        Paint paint=new Paint();
        paint.setColor(Color.rgb(255,0,0));
        canvas.drawCircle(500,500,30, paint);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint.setColor(100);
        canvas.drawCircle(100,100,100, Paint);
    }
}
