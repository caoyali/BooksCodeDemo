package com.example.forev.mycodelibrary;


import android.view.View;
import butterknife.OnClick;

public class SingleTaskAct extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_single_task;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.mNormalActBtn, R.id.mSingleTopActBtn, R.id.mSingleTaskActBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mNormalActBtn:
                openActivity(ActivityStackAct.class);
                break;
            case R.id.mSingleTopActBtn:
                openActivity(SingleTopAct.class);
                break;
            case R.id.mSingleTaskActBtn:
                openActivity(SingleTaskAct.class);
                break;
        }
    }

}