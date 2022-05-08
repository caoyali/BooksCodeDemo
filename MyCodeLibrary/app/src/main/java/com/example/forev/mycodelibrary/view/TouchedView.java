package com.example.forev.mycodelibrary.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.forev.mycodelibrary.utils.MCLLog;

public class TouchedView extends ConstraintLayout {
    private TouchEvent touchEventLis;

    public void setTouchedEventListener(TouchEvent touchedView) {
        this.touchEventLis = touchedView;
    }

    public TouchedView(@NonNull Context context) {
        super(context);
    }

    public TouchedView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchedView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean b = super.dispatchTouchEvent(ev);
        if (null != touchEventLis) {
            touchEventLis.layoutUnConsumeEvent(ev);
        }
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = super.onTouchEvent(event);
        MCLLog.d("消费？ ev=" + event + " b=" + b);
        return b;
    }

    public static interface TouchEvent{
        void layoutUnConsumeEvent(MotionEvent event);
    }
}
