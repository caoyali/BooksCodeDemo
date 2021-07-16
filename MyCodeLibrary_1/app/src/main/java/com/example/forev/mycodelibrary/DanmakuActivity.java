package com.example.forev.mycodelibrary;

import com.example.forev.mycodelibrary.utils.DanmakuConfigUtil;
import com.example.forev.mycodelibrary.utils.LogUtil;

import butterknife.BindView;
import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.ui.widget.DanmakuView;

public class DanmakuActivity extends BaseActivity {
    @BindView(R.id.mDanmakuView)
    DanmakuView mDanmaku;

    @Override
    protected int getLayoutId() {
        return R.layout.act_danmaku;
    }

    @Override
    protected void initView() {
        DanmakuContext danmakuContext = DanmakuConfigUtil.getDanmakuContext();

        BaseDanmakuParser parser = DanmakuConfigUtil.getDefaultDanmakuParser();

        mDanmaku.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                LogUtil.get().d("弹幕准备了！");
                mDanmaku.start();
            }

            @Override
            public void updateTimer(DanmakuTimer timer) {
//                LogUtil.get().d("updateTimer");
            }

            @Override
            public void danmakuShown(BaseDanmaku danmaku) {
                LogUtil.get().d("danmakuShown");
            }

            @Override
            public void drawingFinished() {
                LogUtil.get().d("drawingFinished");
            }
        });

        mDanmaku.prepare(parser, danmakuContext);

        for (int i = 0; i < 50; i++) {
            BaseDanmaku oneDanmu = DanmakuConfigUtil.getOneDanmu(this, danmakuContext, mDanmaku.getCurrentTime(),
                    "哈哈哈哈哈哈哈哈哈");
            mDanmaku.addDanmaku(oneDanmu);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (null != mDanmaku) {
            mDanmaku.resume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mDanmaku) {
            mDanmaku.release();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (null != mDanmaku) {
            mDanmaku.pause();
        }
    }
}
