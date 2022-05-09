package com.example.forev.mycodelibrary;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.example.forev.mycodelibrary.fragment.CameraUsingFra;

import butterknife.OnClick;

public class AudioAndVideoAct extends BaseActivity {
    private CameraUsingFra mCameraUsingFra;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_audeo_and_video;
    }

    @Override
    protected void initView() {
    }

    @OnClick({R.id.mCamera})
    void onClick(View v){
        switch (v.getId()) {
            case R.id.mCamera:
                if (null == mCameraUsingFra) {
                    mCameraUsingFra = new CameraUsingFra();
                }
                openFragment(mCameraUsingFra, "mCameraUsingFra", R.id.mFraPanel);
                break;
        }
    }

    private void openFragment(Fragment fragment, String tag, int id){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(id, fragment, tag)
                .addToBackStack("AudioAndVideoAct")
                .commitAllowingStateLoss();
    }
}
