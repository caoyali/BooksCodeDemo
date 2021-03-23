package com.example.pattern.FlyweightPattern.moxiedemo1;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

class QiziFactroy {
    static Map<String, XiangQi> chatch = new HashMap<>();

    public static XiangQi getXiangqizi(String text) {
        XiangQi qizi = chatch.get(text);
        if (null == qizi) {
            if ("车".equals(text)) {
                qizi = new JuQizi();
                chatch.put(text, qizi);
            } else if ("相".equals(text)) {
                qizi = new XiangQizi();
                chatch.put(text, qizi);
            } else if ("马".equals(text)) {
                qizi = new MaQizi();
                chatch.put(text, qizi);
            }
        }
        return qizi;
    }
}
