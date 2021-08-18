package com.example.array;

import com.example.util.print.Print;

import java.util.Arrays;
import java.util.Random;

/**
 * 纸质书 437
 * 一个简单的二维数组案例。如果说有重点的话，那么就是这个Arrays.deepToString(a) 这个API了。
 */
public class AAC_MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int [][] a = {{1, 2, 3}, {4, 5, 6}};
        // 这块稍微算重点吧。
        Print.print(Arrays.deepToString(a));

        int[][][] b = new int[2][2][4];
        // 默认为0的特性展示出来
        Print.print(Arrays.deepToString(b));


        Random rand = new Random(47);
        /**
         * 粗糙数组。
         * 即： 数组中构成矩阵的每一个向量都可以具有任意长度
         * 看看下面的写法，我们把第一个指定大小了，其余的不指定也是可以的。
         */
        int [][][] c = new int[rand.nextInt(7)][][];
        // 但是如果指定的不是第一位大小，那样写就会报错!!
//        int [][][] d = new int[][rand.nextInt(7)][];

        // 看看a.length这个，他指的就是第一维的数量。就是那个rand.nextInt(7)！这个是可以的。
        for (int i = 0; i < c.length; i++) {
            /**
             * 原来它的赋值类似于剥洋葱，一层一层的，直到最后一层！
             * 这个有意思
             */
            c[i] = new int[rand.nextInt(7)][];
            for (int j = 0; j < c[i].length; j ++) {
                c[i][j] = new int[rand.nextInt(5)];
            }
        }

        Print.print(Arrays.deepToString(c));

    }
}
