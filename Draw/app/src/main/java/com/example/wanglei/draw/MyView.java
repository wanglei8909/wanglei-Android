package com.example.wanglei.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wanglei on 16/4/5.
 */
public class MyView extends View {
    public MyView(Context context,AttributeSet set)
    {
        super(context,set);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setAntiAlias(true);//去锯齿
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        int viewWidth = this.getWidth();
        //绘制圆形
        canvas.drawCircle(viewWidth / 10 + 10, viewWidth / 10 + 10, viewWidth / 10, paint);
        //绘制正方形
        canvas.drawRect(10,viewWidth/5+20,viewWidth/5+10,viewWidth*2/5+20,paint);
        //绘制矩形
        canvas.drawRect(10,viewWidth*2/5+30,viewWidth/5+10,viewWidth/2+30,paint);

        //绘制圆角矩形
        RectF re1 = new RectF(10,viewWidth/2+40,10+viewWidth/5,viewWidth*3/5+40);
        canvas.drawRoundRect(re1,15,15,paint);
        //绘制椭圆
        RectF re11 = new RectF(10,viewWidth*3/5+50,10+viewWidth/5,viewWidth*7/10+50);
        canvas.drawOval(re11,paint);
        //定义一个Path对象封闭成一个三角形
        Path path1 = new Path();
        path1.moveTo(10, viewWidth * 9 / 10 + 60);
        path1.lineTo(viewWidth / 5 + 10, viewWidth * 9 / 10 + 60);
        path1.lineTo(viewWidth / 10 + 10, viewWidth * 7 / 10 + 60);
        //path1.close();
        canvas.drawPath(path1,paint);//绘制

        //定义一个Path对象封闭成一个五角形
        Path path2 = new Path();
        path2.moveTo(10 + viewWidth / 15, viewWidth * 9 / 10 + 70);
        path2.lineTo(10 + viewWidth * 2 / 15, viewWidth * 9 / 10 + 70);
        path2.lineTo(10 + viewWidth / 5, viewWidth + 70);
        path2.lineTo(10 + viewWidth / 10, viewWidth * 11 / 10 + 70);
        path2.lineTo(10, viewWidth + 70);
        path2.close();
        canvas.drawPath(path2, paint);


        //设置填充风格后绘制
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        //绘制圆形
        canvas.drawCircle(viewWidth * 3 / 10 + 20, viewWidth / 10 + 10, viewWidth / 10, paint);
        //绘制正方形
        canvas.drawRect(viewWidth / 5 + 20, viewWidth / 5 + 20, viewWidth * 2 / 5 + 20, viewWidth * 2 / 5 + 20, paint);
        //绘制矩形
        canvas.drawRect(viewWidth/5+20,viewWidth*2/5+30,viewWidth*2/5+20,viewWidth/2+30,paint);
        //绘制圆角矩形
        RectF re2 = new RectF(viewWidth / 5 + 20,viewWidth / 2 + 40,20 + viewWidth * 2 / 5,viewWidth * 3 / 5 + 40);
        canvas.drawRoundRect(re2, 15, 15, paint);
        //绘制椭圆
        RectF re21 = new RectF(20 + viewWidth / 5,viewWidth * 3 / 5 + 50,20 + viewWidth * 2 / 5,viewWidth * 7 / 10 + 50);
        canvas.drawOval(re21, paint);
        //定义一个Path对象封闭成一个三角形
        Path path3 = new Path();
        path3.moveTo(20 + viewWidth / 5, viewWidth * 9 / 10 + 60);
        path3.lineTo(viewWidth * 2 / 5 + 20, viewWidth * 9 / 10 + 60);
        path3.lineTo(viewWidth * 3 / 10 + 20, viewWidth * 7 / 10 + 60);
        //path3.close();
        canvas.drawPath(path3,paint);//绘制

        //定义一个Path对象封闭成一个五角形
        Path path4 = new Path();
        path4.moveTo(20 + viewWidth * 4 / 15, viewWidth * 9 / 10 + 70);
        path4.lineTo(20 + viewWidth / 3, viewWidth * 9 / 10 + 70);
        path4.lineTo(20 + viewWidth * 2 / 5, viewWidth + 70);
        path4.lineTo(20 + viewWidth * 3 / 10, viewWidth * 11 / 10 + 70);
        path4.lineTo(20 + viewWidth / 5, viewWidth + 70);
        path4.close();
        canvas.drawPath(path4, paint);

        //--------设置渐变器后绘制------------
        Shader mShader = new LinearGradient(0,0,40,60,new int[] {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW},null,Shader.TileMode.REPEAT);
        paint.setShader(mShader);
        //设置阴影
        paint.setShadowLayer(25, 20, 20, Color.GRAY);
        //绘制圆形
        canvas.drawCircle(viewWidth / 2 + 30, viewWidth / 10 + 10, viewWidth / 10, paint);
        //绘制正方形
        canvas.drawRect(viewWidth * 2 / 5 + 30, viewWidth / 5 + 20, viewWidth * 3 / 5 + 30, viewWidth * 2 / 5 + 20, paint);
        //绘制矩形
        canvas.drawRect(viewWidth * 2 / 5 + 30, viewWidth * 2 / 5+30,viewWidth * 3 / 5 + 30,viewWidth / 2 + 30,paint);
        //绘制圆角矩形
        RectF re3 = new RectF(viewWidth * 2/ 5 + 30,viewWidth / 2 + 40,30 + viewWidth * 3 / 5,viewWidth * 3 / 5 + 40);
        canvas.drawRoundRect(re3, 15, 15, paint);
        //绘制椭圆
        RectF re31 = new RectF(viewWidth * 2 / 5 + 30,viewWidth * 3 / 5 + 50,30 + viewWidth * 3 / 5,viewWidth * 7 / 10 + 50);
        canvas.drawOval(re31, paint);
        //定义一个Path对象封闭成一个三角形
        Path path5 = new Path();
        path5.moveTo(viewWidth * 2 / 5 + 30, viewWidth * 9 / 10 + 60);
        path5.lineTo(viewWidth * 3 / 5 + 50, viewWidth * 9 / 10 + 60);
        path5.lineTo(viewWidth * 3 / 5 + 30, viewWidth * 7 / 10 + 60);
        //path5.close();
        canvas.drawPath(path5,paint);//绘制

        //定义一个Path对象封闭成一个五角形
        Path path6 = new Path();
        path6.moveTo(30 + viewWidth * 7 / 15, viewWidth * 9 / 10 + 70);
        path6.lineTo(30 + viewWidth * 8 / 15, viewWidth * 9 / 10 + 70);
        path6.lineTo(30 + viewWidth * 3 / 5, viewWidth + 70);
        path6.lineTo(30 + viewWidth / 2 , viewWidth * 11 / 10 + 70);
        path6.lineTo(30 + viewWidth * 2 / 5, viewWidth + 70);
        path6.close();
        canvas.drawPath(path6, paint);


        //--------绘制文字------
        paint.setTextSize(48);
        paint.setShader(null);
        //绘制7个字符串
        canvas.drawText("圆形",60 + viewWidth * 3 / 5 ,viewWidth / 10 + 10 ,paint);
        canvas.drawText("正方形",60 + viewWidth * 3 / 5 ,viewWidth * 3 / 10 + 20,paint);
        canvas.drawText("矩形",60 + viewWidth * 3 / 5,viewWidth * 5 / 10 + 20,paint);
        canvas.drawText("圆角矩形",60 + viewWidth * 3 / 5,viewWidth * 6 / 10 + 30,paint);
        canvas.drawText("椭圆形",60 + viewWidth * 3 / 5,viewWidth * 7 / 10 + 30,paint);
        canvas.drawText("三角形",60 + viewWidth * 3 / 5,viewWidth * 9 / 10 + 30,paint);
        canvas.drawText("五角星",60 + viewWidth * 3 / 5,viewWidth * 11 / 10 + 30,paint);

    }
}
