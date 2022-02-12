package com.example.forev.mycodelibrary;

import android.view.View;
import butterknife.OnClick;

public class ActivityStackAct extends BaseActivity{
    @Override
    protected int getLayoutId() {
        return R.layout.activity_stack_test;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.mSingleTopFlag, R.id.mSingleTask, R.id.mNormal, R.id.mSingleInstance})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mSingleTopFlag:
                openActivity(SingleTopAct.class);
                break;
            case R.id.mSingleTask:
                openActivity(SingleTaskAct.class);
                break;
            case R.id.mNormal:
                openActivity(ActivityStackAct.class);
                break;
            case R.id.mSingleInstance:
                openActivity(SingleInstance.class);
                break;
        }
    }
}
