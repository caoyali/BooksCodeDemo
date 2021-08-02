package com.example.datastructureandalgorithm.algorithm.easysort;

import com.example.datastructureandalgorithm.LogUtil;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class EasySort {
    private static final String TAG = "EasySort";
    private static final int ARRAY_ITEM_COUNT = 15;
    public static void main(String[] args) {
        /**
         * 要求全部从小到大排序
         */
        Random random = new Random();

        int[] a = new int[ARRAY_ITEM_COUNT];

        for (int i = 0; i < ARRAY_ITEM_COUNT; i++) {
            a[i] = random.nextInt(100);
        }

        LogUtil.tagLog(TAG, "原始数据如下：");
        LogUtil.tagLog(TAG, Arrays.toString(a));
        LogUtil.tagLog(TAG, " ");

        int[] popSortArray = Arrays.copyOf(a, a.length);

        EasySort easySort = new EasySort();
        easySort.popSort(popSortArray);

        LogUtil.tagLog(TAG, "easySort=" + Arrays.toString(popSortArray));

        int[] selectArray = Arrays.copyOf(a, a.length);

        easySort.selectSort(selectArray);
        LogUtil.tagLog(TAG, "selectSort=" + Arrays.toString(selectArray));

        int[] insertSortArray = Arrays.copyOf(a, a.length);
        easySort.insertSort(insertSortArray);
        LogUtil.tagLog(TAG, "insertSort=" + Arrays.toString(insertSortArray));
    }

    /**
     * 假设你现在有小到大排序
     * 冒泡排序你可以当做相邻的两个元素之间不断的卷，保证最大的就是后一个，谁大就把谁调到后面，再继续跟后面的元素比较，这样比较一趟下来
     * 排到最后面的肯定就是那个最大（或者最小）的。
     *
     * 特点， 一边比一边换位置。 比较的时候会换位置。卷到最后的都是王者，最后全卷完就拍好了。
     * @param data
     */
    private void popSort(int[] data){
        int temp;

        for (int i = 0; i < data.length; i ++) {
            for (int k = 0; k < data.length - i - 1; k ++) {
                if (data[k] > data[k + 1]) {
                    temp = data[k];
                    data[k] = data[k + 1];
                    data[k + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序. 这次选择排序的算法我没有写错， 但是trans的时候神之迷糊了。导致都算错了。这个得重点注意一下
     * 找出最大的一个，记住索引位置，索引位置哈！等每一趟找出来之后，将这个最大位置的索引位置的数据，与当前趟最后的一个索引数据调换一下，这样就选完了。
     * @param data
     */
    private void selectSort(int[] data) {
        int largestIndex;
        int temp;
        int k;
        for (int i = 0; i < data.length; i ++) {
            largestIndex = 0;
            for (k = 0; k < data.length - i; k ++) {
                if (data[largestIndex] < data[k]) {
                    largestIndex = k;
                }
            }
            temp = data[k - 1];
            data[k - 1] = data[largestIndex];
            data[largestIndex] = temp;
        }
    }

    /**
     * 插入排序
     * 这个排序怎么说呢？我觉得交换次数未免过多。核心环节是不断交换，直到遇到合适的位置。重点在于交换。
     * 这样搞下来会导致很多次交换的。
     *
     * 插入排序就像打扑克牌差不多，但是细节又不一样。我们一般拿到一手乱牌， 一般右手拿乱牌， 左手调顺序用， 首先第一张牌
     * 无论大小，先放到左边，因为就他一个，他可以说是最大的，也可以说是最小的。 然后接下来的右手拿出的牌，就得和左手边的牌比较了。
     * 就要插入到， 比右手牌小和比右手牌大的中间去。 之后的牌也是按照这样比较。最后一趟下来，比完了。。我想每一个打牌的人都有过这样的
     * 经历吧。
     *
     * 插入排序大致上也是这个原理。但是我刚刚提到了，略有不同。那么是什么不同呢？程序毕竟是程序，咱们拿的是一个数组。
     * 比较的时候插入，程序并不像生活中，你觉得合适就直接插入完事儿了。。咱们涉及移动啊。 学过数组的都知道吧，往数组里插入一个
     * 数据，意味着之后的索引位置都得变动！插入排序也避免不了呀。只能在基础上优化插入的次数，但是不能避免。
     *
     * 那么插入排序算法是怎么做的呢？
     * 人家就是两两相比较，谁小谁调换位置在前面。直到碰到个比自己更小的，终止此轮循环。
     * 这毕竟是你自己的笔记，按照你的思路，你此时肯定会对一件事有疑惑。我已经预料到了之后复习的你的这个问题。就是，插入就
     * 意味着多一个空间，那个多出的一个空间最开始到底是谁腾出来的？哈哈哈哈。
     *
     * 仔细看代码，体会体会。你这么聪明。
     */
    private void insertSort(int[] data) {
        int temp;
        for (int i = 0; i < data.length; i ++) {
            for (int k = i; k >= 0 && k < data.length - 1; k --) {
                // K + 1这个位置， 就是新空间。
                if (data[k + 1] < data[k]) {
                    temp = data[k + 1];
                    data[k + 1] = data[k];
                    data[k] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
