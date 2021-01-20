package com.example.pattern.FlyweightPattern.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * 复合享元对象。
 * 这个享元对象描述了多个享元对象的组合关系。显然要比单元性质的享元对象要稍微复杂一点。但是他的operation 也会根据自己的逻辑判断来决定享元对象的状态。
 */
class ConcreteCompositeFlyweight implements Flyweight{

    private Map<Character, Flyweight> map = new HashMap<>();

    public void add(Character intrinsicstate, Flyweight flyweight) {
        map.put(intrinsicstate, flyweight);
    }

    @Override
    public void operation(String extrinsicState) {
        Flyweight flyweight;
        for (Object key : map.keySet()) {
            flyweight = map.get(key);
            flyweight.operation(extrinsicState);
        }
    }
}
