package com.erkuai.taijiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by DELL on 2018/10/6.
 */

public class TaiJiView extends View {

    private Paint whitePaint;
    private Paint blackPaint;
    private float degrees = 0;

    public TaiJiView(Context context) {
        super(context);
        init();
    }

    public TaiJiView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        whitePaint = new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);
        blackPaint = new Paint();
        blackPaint.setAntiAlias(true);
        blackPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        canvas.translate(width/2,height/2);

        canvas.drawColor(Color.GRAY);
        canvas.rotate(degrees);

        //半圆
        int radius = Math.min(width, height) / 2 - 100;
        RectF rectF = new RectF(-radius, -radius, radius, radius);
        canvas.drawArc(rectF,90,180,true,blackPaint);
        canvas.drawArc(rectF,-90,180,true,whitePaint);

        //两个小圆
        int innerRadius = radius / 2;
        canvas.drawCircle(0,-innerRadius,innerRadius,blackPaint);
        canvas.drawCircle(0,innerRadius,innerRadius,whitePaint);

        //鱼眼
        canvas.drawCircle(0, -innerRadius, innerRadius / 4, whitePaint);
        canvas.drawCircle(0, innerRadius, innerRadius / 4, blackPaint);
    }

    public void startAnim(float degrees){
        this.degrees = degrees;
        postInvalidate();

    }
}
