package com.example.array;

import com.example.util.print.Print;

import java.util.Arrays;
import java.util.Random;

/**
 * 纸质书 436
 * 这个代码只是为了证明java的方法，返回一个数组，是多么简单。很普通的
 * 但是C++就做不到如此简单。
 */
public class AAB_IceCream {
    // new Random(47)是什么意思？
    /**
     * 这篇文章有对这个带参构造方法的解释。
     * https://blog.csdn.net/u011240877/article/details/52971166
     *
     * 这个参数叫种子，这个种子是用来决定随机算法的参数。严格说，种子一旦被设置，生成的结果，就不会那么随机了。
     * 如果你不设置种子，得到的值反而很随机。原因是不设置种子，算法会设置默认的种子为时间戳。所以就相当随机了。总之各有各的好处吧。
     *
     */
    private static Random random = new Random(47);
    static final String[] FLAVORS = {"Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint chip", "Mocha Almond Fudge", "Rum Raisin",
    "Praline Cream", "Mud Pie"};

    public static String[] FlavorSet(int n) {
        // 说实话我不知道判断这玩意儿的目的何在?难道是秀下面的Exception？
        if (n > FLAVORS.length) {
            throw new IllegalArgumentException("Set too big!");
        }
        String[] results = new String[n];
        /**
         * 这个值的加入感觉挺有意思哈。就是如果已经有这个口味的了，就不会被再次加入。也就是
         * 生成的口味不会有重复的。我感觉这块写得挺好的。
         */
        boolean[] picked = new boolean[FLAVORS.length];

        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = random.nextInt(FLAVORS.length);
            } while (picked[t]);

            results[i] = FLAVORS[t];
            picked[t] = true;
        }

        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i ++) {
            Print.print(Arrays.toString(FlavorSet(i)));
        }
    }
}
