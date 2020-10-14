package com.example.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 无界通配符
 * 电子书 488页
 * 无界通配符 -- ？
 * 虽然还没有看具体的，但是我感觉这玩意儿没啥意义
 */
public class AAH_UnboundedWilacards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign1(List list) {
        list1 = list;
        list2 = list;
        //我怎么感觉这里跟作者写的不一样了，作者的意思是这里会报错，但是事实上并没有！、
        // 是不是JDK版本更新的比较高，解决了这个问题？
        list3 = list;
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }


    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList<>());
        // 作者说这里也会出错，但是我怎么感觉完全没有问题呀
        assign3(new ArrayList<>());

        assign1(new ArrayList<String>());
        assign2(new ArrayList<String>());
        assign3(new ArrayList<String>());

        List<?> wildList = new ArrayList<>();
        wildList = new ArrayList<String>();
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);

        /**
         * 通篇没有报错，并不像作者讲的那样会报错。我感觉应该是java更新迭代给变了。或许在过去的某一个时段这样是不行的！
         * 说实话，学习知识要扎实。还是敲一遍才能知道现实是什么样子。
         */
    }
}
