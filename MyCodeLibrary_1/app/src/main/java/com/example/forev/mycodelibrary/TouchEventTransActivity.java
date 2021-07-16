package com.example.forev.mycodelibrary;

import android.view.View;

import com.example.forev.mycodelibrary.utils.LogUtil;
import com.example.forev.mycodelibrary.view.MyGroupView;
import com.example.forev.mycodelibrary.view.MyView;

import butterknife.BindView;
import butterknife.OnClick;

public class TouchEventTransActivity extends BaseActivity {
    @BindView(R.id.myGroupView0)
    MyGroupView myGroupView0;

    @BindView(R.id.myGroupView1)
    MyGroupView myGroupView1;

    @BindView(R.id.myView2)
    MyView myView2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_touch_event_trans;
    }

    @Override
    protected void initView() {
        myGroupView0 = findViewById(R.id.myGroupView0);
        myGroupView1 = findViewById(R.id.myGroupView1);
        myView2 = findViewById(R.id.myView2);

        myGroupView0.setTAG("view0");
        myGroupView1.setTAG("view1");
        myView2.setTAG("view2");
    }

    @OnClick({R.id.myGroupView0, R.id.myGroupView1, R.id.myView2})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myView2:
                LogUtil.get().d("view 点击了黄色按钮");
                break;
        }
    }

}