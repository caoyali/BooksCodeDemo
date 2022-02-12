package com.example.forev.mycodelibrary;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.forev.mycodelibrary.simpleView.SurfaceViewDemo;

import butterknife.OnClick;

/**
 * 测试开32个activity会不会引发 30上限崩溃。 听说窗口有30上限来着？？？
 * 如果一个Activity上开超过30个popwindow的话可是会崩溃的偶，但是我们原生的surfaceciew原理是打了一个洞，所以不会触发window相关的，
 * 但是openGL里面的实现原理可是不一样呢。这个家伙的底层申请了资源，并且恰好碰上了30个限制这种问题。
 */
public class TransSurfaceActivity extends BaseActivity {


    private ViewGroup mRoot;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_trans_aurface;
    }

    @Override
    protected void initView() {
        mRoot = findViewById(R.id.mRoot);
        for (int i = 0; i < 50; i++) {
            SurfaceViewDemo surfaceViewDemo = new SurfaceViewDemo(this);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(800, 800);
            surfaceViewDemo.setLayoutParams(params);
            mRoot.addView(surfaceViewDemo);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.mTest32Window})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mTest32Window:
                openActivity(TransSurfaceActivity.class);
                break;
        }
    }
}