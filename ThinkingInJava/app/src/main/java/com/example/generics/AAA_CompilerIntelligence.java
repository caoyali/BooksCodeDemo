package com.example.generics;

import java.util.Arrays;
import java.util.List;

/**
 * 电子书484页 编译器到底有多"聪明"
 */
public class AAA_CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Number> numberList = Arrays.asList(new Integer(2));  //嘻嘻编译不报错
        Integer a = (Integer) numberList.get(0);  // 其实这里只是普通语法的强制转型而已。比较官方店的说法是，向下转型！所以语法上是可以通过的
        numberList.contains(new Integer(2));  // 这句话是语法上可以通过的。因为numberList当时指定的是something extends number！ 符合！
        //这句话在语法上应该也是可以通过的。然后我甚至感觉执行上也是没问题的！
        // 语法上的解释跟上面的那句是一样的原因。运行的通，原因在于擦除这个特性。都是Object，凭什么不能有Long类型的子元素？
        // 一会儿运行一下，我感觉应该是可以运行不会报错的。
        // 运行结果跟我想的是一样的
        numberList.contains(new Long(2));
        // 这一句我想没有必要解释！
        numberList.indexOf(new Integer(2));
    }
}
