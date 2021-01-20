package com.example.pattern.FlyweightPattern.demo1;

import java.util.HashMap;
import java.util.Map;

public class FlayweightFactroy {
    private static Map<String, FlyWeight> pool = new HashMap();

    public static FlyWeight getFlayweight(String extrinsic) {
        FlyWeight flyWeight = null;
        if (pool.containsKey(extrinsic)) {
            flyWeight = pool.get(extrinsic);
            System.out.println("已有 " + extrinsic + " 直接从池子中取出");
        } else {
            flyWeight = new ConcreteFlayweight(extrinsic);
            pool.put(extrinsic, flyWeight);
            System.out.println("创建 " + extrinsic + " 并放入池中");
        }

        return flyWeight;
    }
}
