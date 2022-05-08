package com.example.forev.mycodelibrary.fragment;

import android.hardware.Camera;
import android.view.View;
import android.view.ViewGroup;

import com.example.forev.mycodelibrary.R;
import com.example.forev.mycodelibrary.utils.MCLLog;
import com.example.forev.mycodelibrary.view.ViewPreview;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author caoyl
 * 总结关于摄像头的用法的界面类
 */
public class CameraUsingFra extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "CameraUsingFra";
    private Camera mCamera1;
    private List<Camera.Size> mSupportedPreviewSizes;
    private ViewPreview mPreview;

//    Android系统最初提供了两种比较


    @Override
    protected int getLayoutId() {
        return R.layout.fra_camera_using;
    }

    @Override
    protected void initView(View rootView) {
        MCLLog.i(TAG, "rootView=" + rootView);
//        mRootView.findViewById(R.id.mOriginUsing).setOnClickListener(this);
        mRootView.setOnClickListener(this);
        int count = ((ViewGroup) mRootView).getChildCount();
        for (int i = 0; i < count; i++) {
            if (((ViewGroup) mRootView).getChildAt(i) instanceof ViewPreview) {
                mPreview = (ViewPreview) ((ViewGroup) mRootView).getChildAt(i);
            }
        }

        mRootView.findViewById(R.id.mOriginUsing).setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        MCLLog.i(TAG, "User click v=" + v);
        switch (v.getId()) {
            case R.id.mOriginUsing:
                getCameraInstance();
                mPreview.setCamera(mCamera1);
                break;
            default:
                break;
        }
    }

// 第一种最原始的相机使用方式
//    获取Camera对象实例是直接控制相机流程的第一步，建议从onCreate启动的单独线程上打开camera的方式来打开相机。这种方式非常好，因为这样能够
//    争取时间，从而延迟界面线程。在更基本的实现中，打开相机这一操作一般在onResume中实现， 这样便于重用代码，尽可能的简化流程。
//    也就是，实例在onCreate中获取，，打开在onResume中操作
//    注意： 这个代码必须要相机权限才行！在AndroidManifest里面注意写入： <uses-feature android:name="android.hardware.camera" />   并且要给了权限才行。
//    我这里没有写索要权限的代码，但是事实上你权限给了，这段代码才能正常执行，否则会崩溃
    
    
//    1 预览
//    首先获取一个Camera对象，通过camera.Open()方法就可以获取一个句柄
//    然后想办法让这个camera绑定一个SurfaceHolder，通过调用 camera的setPriviewDisplay()方法就可以设置
//    SurfaceHolder这种东西就已经跟我们的界面有关系了，因为 SurFaceHolder的获取方式是调用surface的getHolder方法来的。也就是Surface天然给外部提供了一个控制器。
//    但是我发现我让相机开启是时机，写到onclick中它就不行，不知道是啥原因，我觉得这我兔血也得给他总结完
    private void getCameraInstance(){
        releaseCamera();
        // 获取就是打开，打开就是获取，不知道为什么怎么是这样的操作。这种操作有点像C++那种写代码方式了！
        mCamera1 = Camera.open(); // Android从9开始是可以支持多个设备的，也就意味着我们可以选择某个摄像头，但是我们也可以调用老接口，这样默认给出的是第一个后置摄像头。
        boolean isOpen = (!(null == mCamera1));
        MCLLog.i(TAG, "isOpen=" + isOpen);
    }

    private void releaseCamera() {
        if (null != mCamera1) {
            mCamera1.release();
            mCamera1 = null;
        }
    }

}
