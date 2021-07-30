package com.example.datastructureandalgorithm.algorithm.easysort;

import com.example.datastructureandalgorithm.LogUtil;

import java.util.Arrays;
import java.util.Random;

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
    }

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
}
