package com.example.forev.mycodelibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.forev.mycodelibrary.utils.LogUtil;

public class MyView extends android.support.v7.widget.AppCompatTextView {
    private String TAG = "";
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTAG(String tag) {
        this.TAG = tag + " ";
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.get().d(TAG + "开始分发 ev=" + ev);
        boolean b = super.dispatchTouchEvent(ev);
        LogUtil.get().d(TAG + "结束分发， result=" + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.get().d(TAG + "开始onTouchEvent ev=" + event);
        boolean b = super.onTouchEvent(event);
        LogUtil.get().d(TAG + "结束onTouchEvent result=" + b);
        return b;
    }
}
