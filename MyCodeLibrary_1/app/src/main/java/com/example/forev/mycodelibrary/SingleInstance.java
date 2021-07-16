package com.example.forev.mycodelibrary;

import android.view.View;

import butterknife.OnClick;

public class SingleInstance extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_single_instance;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.mNormalBtn, R.id.mSingleTaskBtn, R.id.mSingleTopBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mNormalBtn:
                openActivity(ActivityStackAct.class);
                break;
            case R.id.mSingleTaskBtn:
                openActivity(SingleTaskAct.class);
                break;
            case R.id.mSingleTopBtn:
                openActivity(SingleInstance.class);
                break;
        }
    }
}