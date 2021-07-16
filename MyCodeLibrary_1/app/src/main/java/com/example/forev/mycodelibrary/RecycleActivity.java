package com.example.forev.mycodelibrary;

import android.support.v7.widget.RecyclerView;

import butterknife.BindView;

public class RecycleActivity extends BaseActivity{
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycel;
    }

    @Override
    protected void initView() {
        mRecyclerView = findViewById(R.id.mRecyclerView);
        
    }
}
