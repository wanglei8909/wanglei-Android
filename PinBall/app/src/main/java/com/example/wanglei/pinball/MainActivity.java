package com.example.wanglei.pinball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //桌面的宽度
    private int tableWidth;
    //高度
    private int tableHeight;
    //球拍的垂直位置
    private int racketY;
    //球拍的高度和宽度
    private final int RACKET_HEIGHT = 30;
    private final int RACKET_WIDTH = 90;
    //小球的大小
    private final int BALL_SIZE = 16;
    //小球纵向的运动速度
    private int ySpeed = 15;
    Random rand = new Random();
    //返回一个-0.5到0.5的比率用于控制小球的运动方向
    private double xyRate = rand.nextDouble() - 0.5;
    //小球横向的运行速度
    private int xSpeed = (int)(ySpeed*xyRate*2);
    //小球的坐标
    private int ballX = rand.nextInt(200)+20;
    private int ballY = rand.nextInt(10)+20;
    //racketX代表球拍的水平位置
    private int racketX = rand.nextInt(200);
    //游戏是否结束
    private boolean isLose = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏现实
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final GameView gameView = new GameView(this);
        setContentView(gameView);
        //获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        //获取屏幕宽高
        tableWidth = metrics.widthPixels;
        tableHeight = metrics.heightPixels;
        racketY = tableHeight-80;
        final Handler handler = new Handler()
        {
           public void handleMessage(Message msg)
           {
               gameView.invalidate();
           }
        };

        gameView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getKeyCode())
                {
                    case KeyEvent.KEYCODE_A:
                        if (racketX > 0) racketX-=10;
                        break;
                    case KeyEvent.KEYCODE_D:
                        if (racketX < tableWidth-RACKET_WIDTH) racketX+=10;
                        break;
                }
                gameView.invalidate();
                return true;
            }
        });

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //如果小球碰到左边框
                if (ballX <= 0 || ballX >= tableWidth-BALL_SIZE)
                {
                    xSpeed = -xSpeed;
                }
                //如果小球高度超出了球拍的位置，且横向不在球拍范围之内，游戏结束
                if (ballY>=racketY-BALL_SIZE&&(ballX < racketX || ballX > racketX + RACKET_WIDTH))
                {
                    timer.cancel();
                    isLose = true;
                }
                //如果小球位于球拍之内，且到达球拍位置，小球反弹
                else if (ballY <= 0 || (ballY > racketX && ballX>racketX &&  ballX <= racketX + RACKET_WIDTH))
                {
                    ySpeed = -ySpeed;
                }
                //小球坐标增加
                ballX += xSpeed;
                ballY += ySpeed;

                handler.sendEmptyMessage(0x123);
            }
        },0,100);

    }

    class GameView extends View{
        Paint paint = new Paint();
        public GameView(Context context)
        {
            super(context);
            setFocusable(true);
        }
        //重写View的onDraw方法，实现绘画
        public void onDraw(Canvas canvas)
        {
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            //如果游戏结束
            if (isLose)
            {
                paint.setColor(Color.RED);
                paint.setTextSize(40);
                canvas.drawText("游戏已结束",tableWidth/2-100,200,paint);
            }
            else {
                //设置颜色，并绘制小球
                paint.setColor(Color.rgb(255,0,0));
                canvas.drawCircle(ballX,ballY,BALL_SIZE,paint);
                //设置颜色，并绘制球拍
                paint.setColor(Color.rgb(80,80,200));
                canvas.drawRect(racketX,racketY,racketX+RACKET_WIDTH,racketY+RACKET_HEIGHT,paint);
            }
        }

    }
}























