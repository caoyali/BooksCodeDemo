package com.example.forev.mycodelibrary.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.forev.mycodelibrary.utils.LogUtil;

public class MyGroupView extends ConstraintLayout {
    private String TAG = "";
    public MyGroupView(Context context) {
        super(context);
    }

    public MyGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        LogUtil.get().d(TAG + "开始拦截 ev=" + ev);
        boolean b =  super.onInterceptTouchEvent(ev);
        LogUtil.get().d(TAG + "结束拦截， result=" + b);
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
