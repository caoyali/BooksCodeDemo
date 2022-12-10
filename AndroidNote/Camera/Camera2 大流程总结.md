正常步骤

1 权限问题
2 获取当前相机的信息
3 打开相机
4 预览
5 拍照
6 关闭

# 权限问题
PermissionManager出厂，这块没什么好学的

# 获取当前相机的信息
一切都起源于 getSystemService(Contest.CAMERA_SERVICE);
获取到的是CameraManager
然后就是
CameraCharacteristics = cameramanager.getCameraCharicteriscs()


# 打开相机
manager。openCamera（） 获取到  CameraDevice 对象

CameraDevices对象 createCaptureSession 可以绑定surface，Surface初始化的时候就已经需要一个texture了，这个texture是OpenGl生成的那个纹理。

在 onConfigured 回调中拿到session 就可以通信了setRepeatingRequest 了， 里面包含了，流要入到哪个surface中，会简介回调mSurfaceTexture的onFrameAvailable回调中。然后Gl requestRender之后，run起来!

reqest里面可以设置 target