package com.example.forev.mycodelibrary;

import android.view.View;

import butterknife.OnClick;

public class SurfaceTestAct extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_surface_test;
    }

    @Override
    protected void initView() {

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