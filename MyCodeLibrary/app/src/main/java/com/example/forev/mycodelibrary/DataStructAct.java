package com.example.forev.mycodelibrary;

import android.view.View;

import butterknife.OnClick;

public class DataStructAct extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_data_struct;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.mTree})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.mTree:
                openActivity(TreeAct.class);
                break;
        }
    }

}