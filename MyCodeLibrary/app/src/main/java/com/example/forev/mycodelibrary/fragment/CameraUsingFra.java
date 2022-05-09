package com.example.forev.mycodelibrary.fragment;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    private ViewPreview mPreview;
    private FrameLayout mPreviewContainer;
    private TextView mTakePhotoBt;

//    http://www.android-doc.com/reference/android/hardware/Camera.html 这个地址里面讲的挺清楚的
//  首先用照相机前，不要忘了向系统声明一些权限。这种是无论你用那种API都不可避免的一些代码
//  <uses-permission android:name="android.permission.CAMERA" />
//  <uses-feature android:name="android.hardware.camera" />
//  <uses-feature android:name="android.hardware.camera.autofocus" />

//    Android系统最初提供了两种比较简单的方式可以用于开发相机，其中第一种方式就是直接开一个Intent跳转到一个专门的相机页面进行拍摄。另外一种是利用API1中的Camera进行开发。
//    这个Camera的应用我自己也写了一个相对简单的demo，整体来说是相对简单的。这种方式是比较适用于相机定制，或者开发相机特殊功能的界面，例如对照片做裁剪，滤镜处理，添加贴纸，表情，地点标签等等。
//    对于我们自己控制相机，以下是几个需要的角料
//    - 使用camera来控制相机
//    - 使用surfaceView 或者 TextureView 里展现相机采集的图像
//    - 使用SurfaceHolder来控制surface的尺寸和格式，修改surface的像素，监视surface的变化
//    - 通过SurfaceHolder.Callback来监听surface的变化。

//    api说明
//    Camera为最主要的类，用于管理和操作camera资源，它提供了完整的相机底层接口，支持相机资源切换，设置预览拍摄尺寸，指定光圈，曝光聚焦等相关参数获取预览，拍摄帧数等功能
//    主要方法有以下：
//    open() 获取一个Camera实例
//    setPreviewDisplay(SyrfaceHolder), 绑定绘制预览图像的surface。 Surface指向屏幕窗口原始图像缓冲区(raw buffer)的一个句柄，通过它可以获得这个屏幕上相对的canvas，进而在屏幕上完成绘制
//    view的工作。通过SurfaceHolder可以将Camera和Surface连接起来，当camera和surface连接起来之后，camera获得的预览数据就可以通过surface展示在屏幕上了
//    setPrameters()设置相机参数，包括前后摄像头，闪光灯模式聚焦模式预览和拍照尺寸等
//    startPreview()开始预览，将camera硬件传来的数据显示在绑定的surface上。startPreview()这个方法实际上是可以重复调用多次的。这个别怕。
//    stopPreview()停止预览，关闭底层Camera的帧数据传递以及在surface上的绘制
//    release()释放camera实例。
//    enableShutterSound(boolean enable) 开启或者关闭拍照时候的喀嚓声，默认是开启的。我自己代码测出来的
//    setDisplayOrientation(90) 设置预览的角度, 这个角度值是90度的倍数，不能瞎给
//    takePicture(Camera.ShutterCallback shutter, Camera.PictureCallback raw, Camera.PictureCallback jpeg): 这个是实现相机拍照的主要方法，包含三个回调参数， Shutter是按下快门时的回调
//    raw是获取拍照原始数据的回调， jpeg获取通过压缩成jpg格式的图像回调。当我们调用了takePicture之后预览的图片实际上是停止的，如果你还想触发拍照的话，就得重新调用startPreview()方法
//    autoFocuse(AutofoucuseCallback)自动对焦相关，这个方法只能在SurfaceView准备好之后调用。否则会崩溃哈

//    Camera关于录像相关的接口。我在试的过程中，发现有，reconnect， unLock之类的方法，不知道怎么用。好在文档给的足够好。原来他们是和录像相关的代码
//    unLock()调用可以允许媒体通道介入camera入口
//    MediaRecorder可以与Camera之间相互联系上，用的是MediaRecorder setCamera()方法将句柄传入
//    reconnect() 重新请求lock camera， 没看懂哈这里
//    重新startreview可以重新开始录像




//    SurfaceView
//    用于绘制相机预览图像的类，提供给用户实时的预览图像。普通的View以及派生类实际上是共享一个Surface的所有的绘制都是在UI线程上进行。而SurfaceView是一个比较特殊的view，它并不与其他view共享一个Surface，
//    而是内部持有了一个独立的surface， SurfaceView负责管理这个surface的格式，尺寸以及显示位置。由于UI线程同时还要处理其他的交互逻辑，因此对view的帧率和速度是无法保证的，而surfaceView由于持有
//    一个独立的Surface，因而可以在一个独立的线程中进行绘制，因此可以提供更高的帧率。自定义相机的预览图像由于对更新速度和帧率的要求比较高，所以适合用surfaceView来展示。

//    SurfaceHolder
//    SurfaceHolder是控制Surface的一个抽象接口，注意这里，是Surface而不是SurfaceView哈，它能够控制surface的尺寸和格式，修改surface的像素，监视surface的变化等等，SurfaceHolder的
//    典型应用就是用于SurfaceView中，SurfaceView通过getHolder获取一个surfaceHolder实例，通过后者监听管理surface的状态
//    SurfaceHolder.Callback 接口，负责监听Surface的状态和变化，
//    surfaceCreated(SurfaceHolder holder) 在surface被创建之后立即被调用，在开发自定义相机时，可以重载这个方法，调用camera.open() 和 camera.setPreviewDisplay(SurfaceHolder holder)
//    来实现获取相机资源，连接camera和Surface等操作
//    surfaceChanged(SurfaceHolder holder, int format, int width, int height), 在surface发生format或者size变化时调用，在开发自定义相机的时候，可以通过重载这个方法来执行camera。startPrivew来开启相机预览
//    使得camera的帧数据可以传递给surface，从而实时的展示相机预览图像
//    surfaceDestoryed(SurfaceHolder holder), 在surface被销毁之前，这个方法会被调用，在开发自定义相机时，可以通过重载这个方法调用camera.stopPreview(), camera.release()等
//    来实现停止相机预览以及释放资源等操作。

//    private void test() {
//        mCamera1.
//    }


    @Override
    protected int getLayoutId() {
        return R.layout.fra_camera_using;
    }

    @Override
    protected void initView(View rootView) {
        MCLLog.i(TAG, "rootView=" + rootView);
        // 1 检测你的设备究竟有没有相机功能
        if (!getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            //没有相机的功能
            Toast.makeText(getActivity(), "当前设备没有相机硬件！", Toast.LENGTH_LONG).show();
            return;
        }
        mPreviewContainer = mRootView.findViewById(R.id.mPreviewContainer);
        mTakePhotoBt = mRootView.findViewById(R.id.mTakePhoto);
        mRootView.setOnClickListener(this);
        mRootView.findViewById(R.id.mOriginUsing).setOnClickListener(this);
        mTakePhotoBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        MCLLog.i(TAG, "User click v=" + v);
        switch (v.getId()) {
            case R.id.mOriginUsing:
                getCameraInstance();
                createPreview();
                break;
            case R.id.mTakePhoto:
                mCamera1.startPreview();
                takePhoto();
                break;
            default:
                break;
        }
    }

    private void getCameraInstance(){
        releaseCamera();
        // 获取就是打开，打开就是获取，不知道为什么怎么是这样的操作。这种操作有点像C++那种写代码方式了！
        mCamera1 = Camera.open(); // Android从9开始是可以支持多个设备的，也就意味着我们可以选择某个摄像头，但是我们也可以调用老接口，这样默认给出的是第一个后置摄像头。
        boolean isOpen = (!(null == mCamera1));
        MCLLog.i(TAG, "isOpen=" + isOpen);
        mCamera1.setAutoFocusMoveCallback(new Camera.AutoFocusMoveCallback() {
            @Override
            public void onAutoFocusMoving(boolean b, Camera camera) {
                MCLLog.i(TAG, "b=" + b);
            }
        });

        mCamera1.enableShutterSound(true);
        mCamera1.setDisplayOrientation(90);
    }

    private void releaseCamera() {
        if (null != mCamera1) {
            mCamera1.release();
            mCamera1 = null;
        }
    }

    private void createPreview(){
        if (null == mPreview) {
            mPreview = new ViewPreview(getContext(), mCamera1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            mPreview.setLayoutParams(layoutParams);
            mPreviewContainer.addView(mPreview);
        }
    }

    private void takePhoto() {
        mCamera1.takePicture(new Camera.ShutterCallback() {
                                 @Override
                                 public void onShutter() {
                                     MCLLog.v(TAG, "");
                                 }
                             },
                new Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] bytes, Camera camera) {
                        MCLLog.v(TAG, "");
                    }
                },
                new Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] bytes, Camera camera) {
                        MCLLog.v(TAG, "");
                    }
                });
    }

}
