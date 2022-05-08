package com.example.forev.mycodelibrary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.forev.mycodelibrary.utils.MCLLog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by forev on 2018/11/4.
 */

abstract class BaseFragment extends Fragment {
    private Unbinder mUnbinder;
    protected View mRootView;

    abstract protected int getLayoutId();
    abstract protected void initView(View rootView);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MCLLog.d(this + " onCreate()...");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MCLLog.d(this + " onCreateView()...");
        mRootView = View.inflate(getContext(), getLayoutId(), null);
        mUnbinder = ButterKnife.bind(mRootView);
        initView(mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        MCLLog.d(this + " onViewCreated()...");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        MCLLog.d(this + " onActivityResult()...");
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onStart() {
        MCLLog.d(this + " onStart()...");
        super.onStart();
    }

    @Override
    public void onResume() {
        MCLLog.d(this + " onResume()...");
        super.onResume();
    }

    @Override
    public void onStop() {
        MCLLog.d(this + " onStop()...");
        super.onStop();
    }

    @Override
    public void onPause() {
        MCLLog.d(this + " onPause()...");
        super.onPause();
    }

    @Override
    public void onDestroy() {
        MCLLog.d(this + " onDestroy()...");
        super.onDestroy();
        if (null != mUnbinder) {
            mUnbinder.unbind();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
