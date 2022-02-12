package com.example.forev.mycodelibrary;

import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class SingleTopAct extends BaseActivity {

    @BindView(R.id.openSingleTopBtn)
    Button openSingleTopBtn;
    @BindView(R.id.mOpenNormalBtn)
    Button mOpenNormalBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_single_top;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.openSingleTopBtn, R.id.mOpenNormalBtn})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.openSingleTopBtn:
                openActivity(SingleTopAct.class);
                break;
            case R.id.mOpenNormalBtn:
                openActivity(ActivityStackAct.class);
                break;
        }
    }
}