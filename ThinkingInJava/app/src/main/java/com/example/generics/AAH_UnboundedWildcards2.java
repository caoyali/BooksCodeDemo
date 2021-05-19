package com.example.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * 无界通配符，可以独自使用表示任意。表明实际上你用了泛化的思想，但是实际上并没有什么卵用。
 * 多此一举。爱怎么写就怎么写吧。
 */
public class AAH_UnboundedWildcards2 {
    static Map map1;
    static Map<?, ?> map2;
    static Map<String, ?> map3;

    static void assign1(Map map) {
        map1 = map;
    }

    static void assign2(Map<?, ?> map) {
        map2 = map;
    }

    static void assign3(Map<String, ?> map) {
        map3 = map;
    }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap<>());

//        assign3(new HashMap<>()); 报错，编译不过的。
        assign1(new HashMap<Integer, Integer>());
        assign2(new HashMap<String, Integer>());
        assign3(new HashMap<String, Integer>());
        assign3(new HashMap<String, String>());
    }
}
