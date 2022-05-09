package com.example.forev.mycodelibrary.view;

import android.content.Context;
import android.hardware.Camera;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.forev.mycodelibrary.utils.MCLLog;

import java.util.List;

/**
 * @author caoyl
 * 在拍照的时候用户通常需要看见摄像头预览的画面，然后再按下快门这样，为此，我们可以使用SurfaceView绘制摄像头传感器需要获取的内容的预览效果
 */
public class ViewPreview extends FrameLayout implements SurfaceHolder.Callback {
    private static final String TAG = "ViewPreview";
    private SurfaceView mSurfaceView;
    private SurfaceHolder mHolder;
    private Camera mCamera;

    public ViewPreview(Context context) {
        super(context);
    }

    public ViewPreview(Context context, Camera camera) {
        super(context);
        mSurfaceView = new SurfaceView(context);
        mSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addView(mSurfaceView);

        mHolder = mSurfaceView.getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        this.mCamera = camera;
    }

    public ViewPreview(Context context, AttributeSet attrs) {
        this(context);
    }

    public ViewPreview(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        MCLLog.v(TAG, "");
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        MCLLog.v(TAG, "");
        // Now that the size is known, set up the camera parameters and begin
        // the preview.
        Camera.Parameters parameters = mCamera.getParameters();
//        parameters.setPreviewSize(mSupportedPreviewSizes.width, mSupportedPreviewSizes.height);
        requestLayout();
        mCamera.setParameters(parameters);

        // Important: Call startPreview() to start updating the preview surface.
        // Preview must be started before you can take a picture.
        try {
            mCamera.setPreviewDisplay(mHolder);
        } catch (Exception e) {
            MCLLog.e(TAG, "e=" + e);
        }


        mCamera.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        MCLLog.v(TAG, "");
        if (null != mCamera) {
            mCamera.stopPreview();
            mCamera.release();
        }
    }
}
