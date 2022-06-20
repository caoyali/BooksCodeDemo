package com.example.forev.mycodelibrary.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forev.mycodelibrary.R;
import com.example.forev.mycodelibrary.utils.MCLLog;
import com.example.forev.mycodelibrary.view.ViewPreview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author caoyl
 * 总结关于摄像头的用法的界面类
 */
public class CameraUsingFra extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "CameraUsingFra";
    private static final int USING_TYPE_CAMERA1 = 1;
    private static final int USING_TYPE_CAMERA2 = 2;

    private Camera mCamera1;
    private ViewPreview mPreview;
    private FrameLayout mPreviewContainer;
    private TextView mTakePhotoBt;

    private CameraManager mCameraManager;
    private Handler mCamera2Handler;
    private CameraDevice mCameraDevice;
    private CameraCaptureSession mCameraCaptureSession; //CameraCaptureSession主要就是负责建立一路和相机进行交互的会话，需要通过CameraDevice来创建。 CameraDevice里面有很多创建Builder session的方法。全部封装好了！
    private CaptureRequest.Builder mCameraReuqestBuilder;
    private CaptureRequest.Builder mPreviewRequestBuilder;
    private String mCameraId;
    private CaptureRequest mPreviewRequest;
    private Size mPhotoSize;
    private Surface mImageReaderSurface;
    private Surface mPreviewSurface;
    private int mCurrentUseType;
    private CameraCharacteristics mCameraCharacteristics;

/**
    http://www.android-doc.com/reference/android/hardware/Camera.html 这个地址里面讲的挺清楚的
  首先用照相机前，不要忘了向系统声明一些权限。这种是无论你用那种API都不可避免的一些代码
  <uses-permission android:name="android.permission.CAMERA" />
  <uses-feature android:name="android.hardware.camera" />
  <uses-feature android:name="android.hardware.camera.autofocus" />

    Android系统最初提供了两种比较简单的方式可以用于开发相机，其中第一种方式就是直接开一个Intent跳转到一个专门的相机页面进行拍摄。另外一种是利用API1中的Camera进行开发。
    这个Camera的应用我自己也写了一个相对简单的demo，整体来说是相对简单的。这种方式是比较适用于相机定制，或者开发相机特殊功能的界面，例如对照片做裁剪，滤镜处理，添加贴纸，表情，地点标签等等。
    对于我们自己控制相机，以下是几个需要的角料
    - 使用camera来控制相机
    - 使用surfaceView 或者 TextureView 里展现相机采集的图像
    - 使用SurfaceHolder来控制surface的尺寸和格式，修改surface的像素，监视surface的变化
    - 通过SurfaceHolder.Callback来监听surface的变化。

    api说明
    Camera为最主要的类，用于管理和操作camera资源，它提供了完整的相机底层接口，支持相机资源切换，设置预览拍摄尺寸，指定光圈，曝光聚焦等相关参数获取预览，拍摄帧数等功能
    主要方法有以下：
    open() 获取一个Camera实例
    setPreviewDisplay(SyrfaceHolder), 绑定绘制预览图像的surface。 Surface指向屏幕窗口原始图像缓冲区(raw buffer)的一个句柄，通过它可以获得这个屏幕上相对的canvas，进而在屏幕上完成绘制
    view的工作。通过SurfaceHolder可以将Camera和Surface连接起来，当camera和surface连接起来之后，camera获得的预览数据就可以通过surface展示在屏幕上了
    setPrameters()设置相机参数，包括前后摄像头，闪光灯模式聚焦模式预览和拍照尺寸等
    startPreview()开始预览，将camera硬件传来的数据显示在绑定的surface上。startPreview()这个方法实际上是可以重复调用多次的。这个别怕。
    stopPreview()停止预览，关闭底层Camera的帧数据传递以及在surface上的绘制
    release()释放camera实例。
    enableShutterSound(boolean enable) 开启或者关闭拍照时候的喀嚓声，默认是开启的。我自己代码测出来的
    setDisplayOrientation(90) 设置预览的角度, 这个角度值是90度的倍数，不能瞎给
    takePicture(Camera.ShutterCallback shutter, Camera.PictureCallback raw, Camera.PictureCallback jpeg): 这个是实现相机拍照的主要方法，包含三个回调参数， Shutter是按下快门时的回调
    raw是获取拍照原始数据的回调， jpeg获取通过压缩成jpg格式的图像回调。当我们调用了takePicture之后预览的图片实际上是停止的，如果你还想触发拍照的话，就得重新调用startPreview()方法
    autoFocuse(AutofoucuseCallback)自动对焦相关，这个方法只能在SurfaceView准备好之后调用，并且经过我自己的测试，这个方法使用的范围更小，是startPreview之后调用。否则会崩溃哈.这个方法是干嘛用的呢，
    表面意思当然是对焦哈，但是仍然有许多我们需要学习的点。就是自动对焦，和对焦不是一码事。。。。我这次研究拍照也就是为了研究自动对焦怎么弄来着。但是这个方法如果好好研究，那得从setPrameters的设置模式说起了。(附， Parameter是一个稍微复杂的设置类，这里面的每一个特性我们都应该好好熟悉一番！)
    自动对焦指的是自动计算这个焦点而已，，他没有"对上"这个动作。如果你想要对，，那你得调用autoFocuse方法才行。当然你自己调不调用autoFocus这个方法取决于你的需求，另外的一点是，还取决于你的模式。但是我认为
    无论你模式怎么设置，似乎这个方法的奏效性优先级是最高的
    拿我这次要解决的问题为例，我的目的是尽可能的使照片拍着比较清晰，所以我的方案是在自动对焦完成之后，再捕获照片，那么我首先需要调用
    mCamera1.cancelAutoFocus();  //取消自动对焦
    Camera.Parameters parameters = mCamera1.getParameters(); //获取配置，这个配置必须从mCamera1里面获取，以免set错对象之前的配置被覆盖，导致效果不行
    parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO); //设置为自动对焦模式， Parameters可以设置很多东西，有时间我们好好研究一下
    mCamera1.setParameters(parameters);
    mCamera1.autoFocus(new Camera.AutoFocusCallback(){...}); //调用自动对焦，等对焦完成之后会回调出来。此时你再执行拍照的逻辑，拍下来的图片会更加清晰

    Camera关于录像相关的接口。我在试的过程中，发现有，reconnect， unLock之类的方法，不知道怎么用。好在文档给的足够好。原来他们是和录像相关的代码
    unLock()调用可以允许媒体通道介入camera入口
    MediaRecorder可以与Camera之间相互联系上，用的是MediaRecorder setCamera()方法将句柄传入
    reconnect() 重新请求lock camera， 没看懂哈这里
    重新startreview可以重新开始录像

    关于autoFocusMode
    FocusMode的常量定义在 Camera.Parameters 类中，这个压根就不需要记就应该觉得会是这里的。并且这个类提供了各种设置，和各种查询入口。我觉得碰到不懂的时候好好看看这个类兴许有我们想要的
    FOCUS_MODE_AUTO: 自动对焦模式，应用需要调用 autoFocus(Camera.AutoFocusCallback) 开始进行对焦，只会对焦一次，对焦成功会有回调。 这个方法的优先级我认为是很高的哈
    FOCUS_MODE_INFINITY: 无穷对焦模式，应用场景是比较少的
    FOCUS_MODE_MACRO: 特写镜头对焦模式，应用需要调用autoFocus(AutoFocusCallback)开始对焦。个人感觉这是微距。但我没有时间试了
    FOCUS_MODE_FIXED: 固定焦点模式，焦点在不可调用时都是这种模式，如果Camera能够自动对焦，这种模式会固定焦点，通常应用于超焦距对焦，这种模式是不能调用autFocus(AutoFocusCallback)的
    FOCUS_MODE_EDOF: 扩展景深模式，不知道是个啥！
    FOCUS_MODE_CONTINUOUS_VIDEO: 连续自动对焦模式，主要用于视频录制的 过程中，Camera会不断的尝试聚焦，这是录制视频时对焦模式的最好选择，在设置了Camera的参数后就开始自动对焦，但是调用takePicture时不一定对焦完成
    FOCUS_MODE_CONTINUOUS_PICTURE: 这种模式是对FOCUS_MODE_CONTINUOUS_VIDEO模式的自动对焦应用于拍照的扩展，Camera会不停的尝试连续对焦，对焦频率会比FOCUS_MODE_CONTINUOUS_VIDEO频繁， 当设置了camera参数后开始对焦

 注意如果重新开始自动对焦，首先需要调用cancelAutoFocus，然后再设置自动对焦模式，再调用autoFocus(AutoFocusCallback)，如果当前正在对焦扫描，fucus回调函数将在它完成对焦时回调。如果没有正在对焦扫描，将立即放回。
 autoFocus函数调用后对焦区域是固定的，如果应用想重新开启自动连续对焦，需要首先调动cancelAutoFocus，重新开始预览无法开启自动连续对焦，需要重新autoFocus， 如果想要停止自动连续对焦，应用可以修改对焦模式，


    SurfaceView
    用于绘制相机预览图像的类，提供给用户实时的预览图像。普通的View以及派生类实际上是共享一个Surface的所有的绘制都是在UI线程上进行。而SurfaceView是一个比较特殊的view，它并不与其他view共享一个Surface，
    而是内部持有了一个独立的surface， SurfaceView负责管理这个surface的格式，尺寸以及显示位置。由于UI线程同时还要处理其他的交互逻辑，因此对view的帧率和速度是无法保证的，而surfaceView由于持有
    一个独立的Surface，因而可以在一个独立的线程中进行绘制，因此可以提供更高的帧率。自定义相机的预览图像由于对更新速度和帧率的要求比较高，所以适合用surfaceView来展示。

    SurfaceHolder
    SurfaceHolder是控制Surface的一个抽象接口，注意这里，是Surface而不是SurfaceView哈，它能够控制surface的尺寸和格式，修改surface的像素，监视surface的变化等等，SurfaceHolder的
    典型应用就是用于SurfaceView中，SurfaceView通过getHolder获取一个surfaceHolder实例，通过后者监听管理surface的状态
    SurfaceHolder.Callback 接口，负责监听Surface的状态和变化，
    surfaceCreated(SurfaceHolder holder) 在surface被创建之后立即被调用，在开发自定义相机时，可以重载这个方法，调用camera.open() 和 camera.setPreviewDisplay(SurfaceHolder holder)
    来实现获取相机资源，连接camera和Surface等操作
    surfaceChanged(SurfaceHolder holder, int format, int width, int height), 在surface发生format或者size变化时调用，在开发自定义相机的时候，可以通过重载这个方法来执行camera。startPrivew来开启相机预览
    使得camera的帧数据可以传递给surface，从而实时的展示相机预览图像
    surfaceDestoryed(SurfaceHolder holder), 在surface被销毁之前，这个方法会被调用，在开发自定义相机时，可以通过重载这个方法调用camera.stopPreview(), camera.release()等
    来实现停止相机预览以及释放资源等操作。

    private void test() {
        mCamera1.
    }
**/

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
        mRootView.findViewById(R.id.mCamera2Using).setOnClickListener(this);
        mTakePhotoBt.setOnClickListener(this);

        HandlerThread handlerThread = new HandlerThread("Camera2Test");
        handlerThread.start();
        mCamera2Handler = new Handler(handlerThread.getLooper());
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v){
        MCLLog.i(TAG, "User click v=" + v);
        switch (v.getId()) {
            case R.id.mOriginUsing:
                mCurrentUseType = USING_TYPE_CAMERA1;
                getCameraInstance();
                createPreview();
                break;
            case R.id.mCamera2Using:
                // 采用Camera2的API
                mCurrentUseType = USING_TYPE_CAMERA2;
                getCamera2Instance();
                break;
            case R.id.mTakePhoto:
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
        Camera.Parameters parameters = mCamera1.getParameters();
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
        mCamera1.setParameters(parameters);
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void takePhoto() {
        if(USING_TYPE_CAMERA1 == mCurrentUseType) {
            mCamera1.startPreview();
            mCamera1.cancelAutoFocus();
            Camera.Parameters parameters = mCamera1.getParameters();
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
            mCamera1.setParameters(parameters);
            mCamera1.autoFocus(new Camera.AutoFocusCallback() {
                @Override
                public void onAutoFocus(boolean b, Camera camera) {
                    MCLLog.i(TAG, "自动对焦了，b=" + b);
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
            });
        } else {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mCameraCaptureSession.stopRepeating();
                    mCameraReuqestBuilder = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
                    mCameraReuqestBuilder.set(CaptureRequest.JPEG_ORIENTATION, 90);
                    mCameraReuqestBuilder.addTarget(mImageReaderSurface);

                    if (null != mCameraCharacteristics) {
                        MCLLog.i(TAG, "开始对焦了！");
                        MeteringRectangle meteringRectangle = calcTapAreaForCamera2(mCameraCharacteristics, 20, 1);
                        MeteringRectangle[] rectangles = new MeteringRectangle[]{meteringRectangle};
                        mCameraReuqestBuilder.set(CaptureRequest.CONTROL_AF_MODE,CaptureRequest.CONTROL_AF_MODE_AUTO);
                        mCameraReuqestBuilder.set(CaptureRequest.CONTROL_AE_REGIONS, rectangles);
                        mCameraReuqestBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, rectangles);
                        try {
                            mCameraCaptureSession.setRepeatingRequest(mCameraReuqestBuilder.build(), null, null);
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }

                        mCameraReuqestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, CaptureRequest.CONTROL_AF_TRIGGER_START);

                        try {
                            Log.i(TAG, "take photo with autofocus");
                            mCameraCaptureSession.capture(mCameraReuqestBuilder.build(), new CameraCaptureSession.CaptureCallback() {
                                @Override
                                public void onCaptureStarted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, long timestamp, long frameNumber) {
                                    super.onCaptureStarted(session, request, timestamp, frameNumber);
                                }

                                @Override
                                public void onCaptureProgressed(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull CaptureResult partialResult) {
                                    super.onCaptureProgressed(session, request, partialResult);
                                }

                                @Override
                                public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
                                    super.onCaptureCompleted(session, request, result);
                                    try {
                                        mCameraCaptureSession.setRepeatingRequest(mPreviewRequest, null, null);
                                    } catch (CameraAccessException e) {
                                        e.printStackTrace();
                                        MCLLog.e(TAG, "e=" + e);
                                    }
                                }

                                @Override
                                public void onCaptureFailed(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull CaptureFailure failure) {
                                    super.onCaptureFailed(session, request, failure);
                                }

                                @Override
                                public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession session, int sequenceId, long frameNumber) {
                                    super.onCaptureSequenceCompleted(session, sequenceId, frameNumber);
                                }

                                @Override
                                public void onCaptureSequenceAborted(@NonNull CameraCaptureSession session, int sequenceId) {
                                    super.onCaptureSequenceAborted(session, sequenceId);
                                }

                                @Override
                                public void onCaptureBufferLost(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull Surface target, long frameNumber) {
                                    super.onCaptureBufferLost(session, request, target, frameNumber);
                                }
                            }, null);
                        } catch (CameraAccessException e){
                            e.printStackTrace();
                        }

                    } else {
                        Log.e(TAG, "没有对焦  mCameraCharacteristics=null!");
//                        origin takePhoto
                        CaptureRequest captureRequest  = mCameraReuqestBuilder.build();

                        mCameraCaptureSession.stopRepeating();
                        // todo
                        mCameraCaptureSession.capture(captureRequest, null, null);
                    }
                }

            } catch (CameraAccessException e) {
                e.printStackTrace();
                Log.e(TAG, "相机访问异常");
            } catch (Exception e) {
                Log.e(TAG, "e=" + e);
            }
        }

    }


    /**
     * 一定要在surface创建完成之后openCamera？？？
     */
    @SuppressLint("MissingPermission")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void getCamera2Instance() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mCameraManager = (CameraManager) getActivity().getSystemService(Context.CAMERA_SERVICE);
            }

            CameraCharacteristics characteristics = null;
            String[] deviceList = mCameraManager.getCameraIdList();  // 0, 1
            MCLLog.i(TAG, "deviceList=" + Arrays.toString(deviceList));
            mCameraId = deviceList[0];

            characteristics = mCameraManager.getCameraCharacteristics(mCameraId);
            StreamConfigurationMap configurationMap = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            List<Size> sizes = Arrays.asList(configurationMap.getOutputSizes(SurfaceTexture.class));
            MCLLog.i(TAG, "size=" + sizes);
            Collections.sort(sizes, new Comparator<Size>() {
                @Override
                public int compare(Size o1, Size o2) {
                    return o1.getWidth() * o1.getHeight() - o2.getWidth() * o2.getHeight();
                }
            });
            for (Size size : sizes) {
                if (size.getWidth() == 1280 && size.getHeight() == 960) {
                    mPhotoSize = size;
                    MCLLog.v(TAG, "mPhotoSize=" + mPhotoSize);
                    break;
                }
            }

            if (mPhotoSize == null) {
                //TODO CaoYl 这里会越界吗
                mPhotoSize = sizes.get(15);
                MCLLog.v(TAG, "mPhotoSize=" + mPhotoSize);
            }
            Collections.reverse(sizes);


            final SurfaceView surfaceView = new SurfaceView(getContext());
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            surfaceView.setLayoutParams(params);
            mPreviewContainer.addView(surfaceView);

            mPreviewSurface = surfaceView.getHolder().getSurface();

            //初始化拍照 ImageReader
            ImageReader photoReader = ImageReader.newInstance(mPhotoSize.getWidth(), mPhotoSize.getHeight(), ImageFormat.JPEG, 2);
            photoReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                @Override
                public void onImageAvailable(ImageReader imageReader) {
                    MCLLog.i(TAG, "");
                }
            }, null);
            mImageReaderSurface = photoReader.getSurface();

            surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    try {
                        MCLLog.v(TAG, "");
                        mCameraManager.openCamera(mCameraId, new CameraDevice.StateCallback() {
                            @Override
                            public void onOpened(@NonNull CameraDevice cameraDevice) {
                                MCLLog.v(TAG, "");
                                mCameraDevice = cameraDevice;

                                try {
                                    mPreviewRequestBuilder = CameraUsingFra.this.mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW); //这里的参数特别多
                                    mPreviewRequestBuilder.addTarget(mPreviewSurface);
                                    mPreviewRequest = mPreviewRequestBuilder.build();
                                    cameraDevice.createCaptureSession(Arrays.asList(mPreviewSurface, mImageReaderSurface), new CameraCaptureSession.StateCallback() {
                                        @Override
                                        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                                            MCLLog.v(TAG, "");

                                            mCameraCaptureSession = cameraCaptureSession;

                                            try {
                                                mCameraCaptureSession.setRepeatingRequest(mPreviewRequest, new CameraCaptureSession.CaptureCallback() {
                                                    @Override
                                                    public void onCaptureStarted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, long timestamp, long frameNumber) {
                                                        super.onCaptureStarted(session, request, timestamp, frameNumber);
                                                    }

                                                    @Override
                                                    public void onCaptureProgressed(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull CaptureResult partialResult) {
                                                        super.onCaptureProgressed(session, request, partialResult);
                                                    }

                                                    @Override
                                                    public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
                                                        super.onCaptureCompleted(session, request, result);
                                                    }

                                                    @Override
                                                    public void onCaptureFailed(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull CaptureFailure failure) {
                                                        super.onCaptureFailed(session, request, failure);
                                                    }

                                                    @Override
                                                    public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession session, int sequenceId, long frameNumber) {
                                                        super.onCaptureSequenceCompleted(session, sequenceId, frameNumber);
                                                    }

                                                    @Override
                                                    public void onCaptureSequenceAborted(@NonNull CameraCaptureSession session, int sequenceId) {
                                                        super.onCaptureSequenceAborted(session, sequenceId);
                                                    }

                                                    @Override
                                                    public void onCaptureBufferLost(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull Surface target, long frameNumber) {
                                                        super.onCaptureBufferLost(session, request, target, frameNumber);
                                                    }
                                                }, null);
                                            } catch (CameraAccessException e) {
                                                e.printStackTrace();
                                                MCLLog.i(TAG, "e=" + e);
                                            }
                                        }

                                        @Override
                                        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
                                            MCLLog.i(TAG, "");
                                        }
                                    }, null);
                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onDisconnected(@NonNull CameraDevice cameraDevice) {

                            }

                            @Override
                            public void onError(@NonNull CameraDevice cameraDevice, int i) {

                            }
                        }, null);

                        mCameraCharacteristics = mCameraManager.getCameraCharacteristics(mCameraId);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                        MCLLog.e(TAG, "e=" + e);
                    }
                }

                @Override
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

                }
            });
        } catch (Exception e) {
            MCLLog.e(TAG, "e=" + e);
        }


    }

    private MeteringRectangle calcTapAreaForCamera2(CameraCharacteristics c, int areaSize, int
            weight) {
        Rect rect = c.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        Log.d(TAG, "active Rect:" + rect.toString());
        Rect newRect;
        int leftPos, topPos;
        leftPos = (rect.left + rect.right) / 2;
        topPos = (rect.top + rect.bottom) / 2;
        int left = clamp(leftPos - areaSize, 0, rect.right);
        int top = clamp(topPos - areaSize, 0, rect.bottom);
        int right = clamp(leftPos + areaSize, leftPos, rect.right);
        int bottom = clamp(topPos + areaSize, topPos, rect.bottom);
        newRect = new Rect(left, top, right, bottom);
        Log.d(TAG, newRect.toString());
        // 构造MeteringRectangle
        return new MeteringRectangle(newRect, weight);
    }

    private int clamp(int x, int min, int max) {
        if (x > max) {
            return max;
        }
        if (x < min) {
            return min;
        }
        return x;
    }
}
