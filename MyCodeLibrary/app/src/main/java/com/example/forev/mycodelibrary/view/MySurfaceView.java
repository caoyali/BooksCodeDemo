package com.example.forev.mycodelibrary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * surfaceview 实际上是一个可以用子线程去画东西的view，
 * 你可以理解为，它可以画任何东西，可以画动画，图片甚至视频
 * 所以说这个view与并不一定就是给视频使用的
 *
 *
 * surfaceview 里面有一个surfaceHolder， holder相当于一个控制器。这个里面可以给我们吐出来一个
 * 十分重要的关于画画的参数，canvas
 *
 * 有了canvas，你可以画你想要的一切！
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = MySurfaceView.class.getSimpleName();
    private SurfaceHolder holder;
    private MyTread myTread;


    public MySurfaceView(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        myTread = new MyTread(holder);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG, "surfaceCreated");
        myTread.setRun(true);
        myTread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "surfaceDestroyed");
        myTread.setRun(false);
    }

    /**
     * 从holder中取出canvas画画
     */
    private class MyTread extends Thread {
        private SurfaceHolder holder;
        private boolean run;

        private SparseArray<String> colors = new SparseArray();

        public MyTread(SurfaceHolder holder) {
            this.holder = holder;
            colors.append(0, "#9400D3");
            colors.append(1, "#00FFFF");
            colors.append(2, "#00FA9A");
            colors.append(4, "#FF8C00");
        }

        @Override
        public void run() {
            int counter = 0;
            Canvas canvas = null;
            while (run) {
                try {
                    // 获取canvas对象，并锁定
                    canvas = holder.lockCanvas();
                    canvas.drawColor(Color.parseColor(nextColor()));

                    Paint p = new Paint();
                    p.setColor(Color.WHITE);
                    p.setTextSize(30);

                    Rect rect = new Rect(100, 50, 380, 330);
                    canvas.drawRect(rect, p);
                    canvas.drawText("Interval=" + counter + " seconds.", 100, 410, p);
                    Thread.sleep(1000);
                    counter ++;
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (canvas != null) {
                        holder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }

        public boolean isRun() {
            return run;
        }

        public void setRun(boolean run) {
            this.run = run;
        }

        private int index = 0;
        private String nextColor() {
            if (index > colors.size()) {
                index = 0;
            }
            return colors.get(index ++);
        }

    }
}