package com.example.forev.mycodelibrary.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;

import java.util.HashMap;
import java.util.Map;

import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;

public class DanmakuConfigUtil {
    public static DanmakuContext getDanmakuContext() {
        Map<Integer, Integer> maxlines = new HashMap<>();
        maxlines.put(BaseDanmaku.TYPE_SCROLL_RL, 5);

        Map<Integer, Boolean> overMap = new HashMap<>();
        overMap.put(BaseDanmaku.TYPE_SCROLL_RL, true);
        overMap.put(BaseDanmaku.TYPE_FIX_TOP, true);

        DanmakuContext danmakuContext = DanmakuContext.create();
        danmakuContext.setDanmakuStyle(IDisplayer.DANMAKU_STYLE_STROKEN, 3)
                .setDuplicateMergingEnabled(false)
                .setScrollSpeedFactor(1.2f)
                .setScaleTextSize(1.2f)
                .setMaximumLines(maxlines)
                .preventOverlapping(overMap)
                .setDanmakuMargin(40);

        return danmakuContext;
    }

    /**
     * [生成默认解析]
     * @type {[type]}
     */
    public static BaseDanmakuParser getDefaultDanmakuParser(){
        return new BaseDanmakuParser() {
            @Override
            protected IDanmakus parse() {
                return new Danmakus();
            }
        } ;
    }

    /**
     * 获取一条弹幕
     * @param mDmkContext
     * @param time
     * @param content
     * @return
     */
    public static BaseDanmaku getOneDanmu(Context context, DanmakuContext mDmkContext,long time, String content){
        //创建一条从右侧开始滚动的弹幕
        BaseDanmaku danmaku = mDmkContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL) ;
        if(danmaku == null || !danmaku.isPrepared()){
            return null ;
        }
        danmaku.text = content ;
        danmaku.padding = 5 ;
        danmaku.priority = 0 ;
        danmaku.isLive = true ;
        danmaku.setTime(time+1000);
        danmaku.textSize = sp2px(context,18f) ;
        danmaku.textColor = Color.RED ;
        danmaku.borderColor = Color.GREEN ;
        return danmaku ;
    }

    /**
     * sp转px的方法。
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
