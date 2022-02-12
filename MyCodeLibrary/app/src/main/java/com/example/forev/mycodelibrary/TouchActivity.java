package com.example.forev.mycodelibrary;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.forev.mycodelibrary.utils.LogUtil;
import com.example.forev.mycodelibrary.view.TouchedView;

import java.util.logging.Logger;

import butterknife.BindView;
import butterknife.OnClick;

public class TouchActivity extends BaseActivity {
    @BindView(R.id.mRootView)
    ViewGroup mRootView;

    @BindView(R.id.第一层父容器)
    ViewGroup 第一层父容器;

    @BindView(R.id.第一层父容器中大按钮)
    Button 第一层父容器中大按钮;

    @BindView(R.id.模拟webView)
    TouchedView 模拟webView;

    @BindView(R.id.模拟WebView中需要处理的按钮)
    Button 模拟WebView中需要处理的按钮;

    @BindView(R.id.mTextView)
    TextView mTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_touch;
    }

    @Override
    protected void initView() {
        mRootView = findViewById(R.id.mRootView);
        第一层父容器 = findViewById(R.id.第一层父容器);
        第一层父容器中大按钮 = findViewById(R.id.第一层父容器中大按钮);
        模拟webView = findViewById(R.id.模拟webView);
        mTextView = findViewById(R.id.mTextView);
        模拟WebView中需要处理的按钮 = findViewById(R.id.模拟WebView中需要处理的按钮);

//        模拟webView.setTouchedEventListener(new TouchedView.TouchEvent() {
//            @Override
//            public void layoutUnConsumeEvent(MotionEvent event) {
//                LogUtil.get().d("透传事件 event=" + event);
//                第一层父容器.onTouchEvent(event);
//            }
//        });

        模拟webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LogUtil.get().d("触摸 event=" + event);
                第一层父容器.dispatchTouchEvent(event);
                return true;
            }
        });
//        mWebView.loadUrl("http://confluence.koolearn-inc.com/pages/viewpage.action?pageId=47710967");
    }

    @OnClick({R.id.第一层父容器中大按钮, R.id.第一层父容器, R.id.模拟WebView中需要处理的按钮, R.id.模拟webView})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.模拟webView:
                LogUtil.get().d("CLICK 点击最上层容器，但是这个事件不处理，透传给下个布局");
                break;
            case R.id.第一层父容器:
                LogUtil.get().d("CLICK 点击下层父容器了");
                break;
            case R.id.第一层父容器中大按钮:
                LogUtil.get().d("CLICK 点击第一层父容器中大按钮");
                break;
            case R.id.模拟WebView中需要处理的按钮:
                LogUtil.get().d("CLICK 点击模拟WebView中需要处理的按钮");
            default:
                return;
        }
    }
}