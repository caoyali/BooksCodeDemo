package com.example.generics;

import java.util.List;

/**
 * 电子书485页
 * 逆差
 * wildcards 通配符  super
 * <? super SomeClass> 的意思是，？这个类是SomeClass的"基类"
 * <? extends SomeClass> 决定了    X < SomeClass 的话
 * 那么 <? super SomeClass> 则是 描述 X > someClass这种类似的关系的
 */
public class AAC_SuperTypeWildcards {
    static void wirteTo(List<? super Integer> someNumbers) {
        someNumbers.add(new Integer(3));
//        someNumbers.add(new Number()); // 这一行无法通过的原因是Number是一个抽象类。
//        someNumbers.add('123'); // 类型显然是不对的
    }
}
