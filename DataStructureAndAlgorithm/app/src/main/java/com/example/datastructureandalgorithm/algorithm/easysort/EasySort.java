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
}
