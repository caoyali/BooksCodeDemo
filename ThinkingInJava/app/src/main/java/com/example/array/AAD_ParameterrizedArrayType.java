package com.example.array;

import java.util.ArrayList;
import java.util.List;

// P 440 数组与泛型
public class AAD_ParameterrizedArrayType {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la; //我靠为什么能强转？？？
        ls[0] = new ArrayList<String>(); // 泛型是可以向下更为详细的转换的，所以这里没有问题，我认为解释合理。
//        ls[1] = new ArrayList<Integer>(); // 这句错误的原因是，Integer并不喝String是一样的。
        Object[] objects = ls; // 类型上的包含关系所以可以过，逻辑合理。
        objects[0] = new ArrayList<Integer>(); // 我靠！！！！！这不就卡出bug来了么！！！我靠！！

        List<AAA_ContainerComparision>[] testData = ((List<AAA_ContainerComparision>[]) new List[10]);
        for (int i = 0; i < testData.length; i ++) {
            testData[i] = new ArrayList<AAA_ContainerComparision>(); //为何要如此烧脑。
        }
    }
}
