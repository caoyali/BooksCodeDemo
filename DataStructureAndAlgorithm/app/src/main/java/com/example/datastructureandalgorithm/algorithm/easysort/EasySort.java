package com.example.datastructureandalgorithm.algorithm.easysort;

import com.example.datastructureandalgorithm.LogUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.TreeMap;

public class EasySort {
    private static final String TAG = "EasySort";
    private static final int ARRAY_ITEM_COUNT = 150000;
    public static void main(String[] args) {
        /**
         * 要求全部从小到大排序
         */
        Random random = new Random();

        int[] a = new int[ARRAY_ITEM_COUNT];

        for (int i = 0; i < ARRAY_ITEM_COUNT; i++) {
            a[i] = random.nextInt(100000);
        }

//        LogUtil.tagLog(TAG, "原始数据如下：");
//        LogUtil.tagLog(TAG, Arrays.toString(a));
//        LogUtil.tagLog(TAG, " ");

//        int[] popSortArray = Arrays.copyOf(a, a.length);

        EasySort easySort = new EasySort();
//        easySort.popSort(popSortArray);

//        LogUtil.tagLog(TAG, "easySort=" + Arrays.toString(popSortArray));

//        int[] selectArray = Arrays.copyOf(a, a.length);

//        easySort.selectSort(selectArray);
//        LogUtil.tagLog(TAG, "selectSort=" + Arrays.toString(selectArray));

//        int[] insertSortArray = Arrays.copyOf(a, a.length);
//        easySort.insertSort(insertSortArray);
//        LogUtil.tagLog(TAG, "insertSort=" + Arrays.toString(insertSortArray));


        // 接下来是几个比较高端的排序了！
        int[] quickSortArray = Arrays.copyOf(a, a.length);
        long insertTime = System.currentTimeMillis();
        easySort.quickSort(quickSortArray, 0, quickSortArray.length - 1);
        LogUtil.tagLog(TAG, "插入排序用时：" + (System.currentTimeMillis() - insertTime));
//        LogUtil.tagLog(TAG, "quickSort=" + Arrays.toString(quickSortArray));


        int[] shellSortArray = Arrays.copyOf(a, a.length);
        long shellTime = System.currentTimeMillis();
        easySort.shellSort(shellSortArray);
        LogUtil.tagLog(TAG, "希尔排序用时：" + (System.currentTimeMillis() - shellTime));
//        LogUtil.tagLog(TAG, "shellSort" + Arrays.toString(shellSortArray));


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
     * 首先你要记住的是，左手拿的牌，永远是已经排好序的！！这个非常非常重点，所以要记下来！！！
     *
     * 人家就是两两相比较，谁小谁调换位置在前面。直到碰到个比自己更小的，终止此轮循环。
     * 这毕竟是你自己的笔记，按照你的思路，你此时肯定会对一件事有疑惑。我已经预料到了之后复习的你的这个问题。就是，插入就
     * 意味着多一个空间，那个多出的一个空间最开始到底是谁腾出来的？哈哈哈哈。
     *
     * 仔细看代码，体会体会。你这么聪明。
     */
    private void insertSort(int[] data) {
        int temp;
        for (int i = 0; i < data.length; i ++) { //总共n个数

            //注意k的赋值是i, 因为这是第i趟遍历了，假定从左往右数，已经有i个有序的数了。就像我们打牌，左手的那波永远都是有顺序的！
            // 想想，假设第一次排牌， 那么i 就是0， 强两个牌进行排序，自然就是这两个牌从小到大了。
            // i=1的时候，右手拿出第三张牌了已经，第三张牌这样冒泡往前卷，迟早会定位到合适的位置。就是这个道理'。
            for (int k = i; k + 1 < data.length && k >= 0; k --) {
//                k + 1就是右手拿的新牌，就像冒泡一样置换。
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

    /**
     * 快排
     *
     * 我没记错的话，基本思想是这样的，就是采用了二分的思维。取出一个比较基数进行排序。最终使左面的数比基数小，右面的数比基数大。
     * 然后再将这个排好的数组进行二分切分。周而复始，直至全部排完。
     *
     * 至于怎么实现。三点临时变量， 左索引，右索引， 比较基数。
     * 要记住两个索引位置，左，右，在两侧，取索引位置数，不断的与基数进行对比，然后如果需要，就进行置换。直到
     * 左右两个索引位置重合了。一趟排序算是完成了。
     *
     * 如何很简洁的实现这个逻辑呢，头疼ing。。。
     *
     * 总算是写完了。 记住以下几点：
     * 1 小心减超，所以加判断。
     * 2 while 套 两个同级的while。 这两个同级的while，是不断让指针前移的操作。移不动了再赋值。
     * 3 每一处都要对应的 start++ 或者 end -- 视情况而定。
     * 4 二分嘛，所以要递归！递归条件判断好哈！
     *
     * 速记： start和 end 优先往里面移动!移动条件就是和基数比较大小，直到找到不能移动马上替换的项。执行替换之后，酌情判断end-- 或者start++
     * 之后再按照刚才步骤操作另外一个对立面的数。 比如你先对左侧往前捋，捋到必须置换数据了，置换完后确保指针变化对之后，再开始捋右侧，按照完全相对的
     * 步骤处理。两者是对立的。希望写的时候动脑子哈。
     *
     * 如果还是不熟的话，那就默写一下吧。这个很容易面试到的。
     * @param data
     */
    private void quickSort(int[] data, int start, int end) {
        if (end <= start) {
            return;
        }

        int p = data[start];
        int originStart = start;
        int originEnd = end;

        while (end > start) {
            while (data[end] > p && end > start) {
                end --;
            }

            // 这一处需要格外记一下！为什么还加判断呢？原因很简单， 上面的代码，很可能减超！懂？
            // 我们看整套方法，只是在一个大数组的局域部分来回搬值而已。但是上面很危险的是减超，或者加超。
            // 超的话很容易会改掉另外二分区域的值，整套计算下来就会出大麻烦。
            if (end > start) {
                // 这个技巧需要记一下。因为p这个值迟早是中间的那个数。所以理论上来讲，算是已经为倒腾数据永远腾了一个空。
                // 所以此处你会发现并没有按照传统进行trans操作，而是直接赋值！因为end赋值给start之后，end的值就没有意义了，然鹅下一个被替换的就是这个位置
                // 随意它迟早会给一个合理的值的。不必担心
                data[start] = data[end];
                start ++;
            }

            while (data[start] < p && end > start) {
                start ++;
            }
            if (end > start) {
                data[end] = data[start];
                end --;
            }
        }
        data[end] = p;
        quickSort(data, originStart, end - 1);
        quickSort(data, end + 1, originEnd);
    }

    /**
     * 希尔排序
     * 这个排序方法我总是忘，一遍又一遍的总是忘掉。简直了。
     *
     * 如何用代码表示好分组，之后拿组里的数据遍历呢？这个东西不是很好映射，等我吃完饭再回来整理。这个挺难理解的。
     * 首先四层for循环，我就觉得离谱！我得看看网上！
     *
     * 有个细节的是，到底是两两交换， 还是每个分步按照插入排序来。
     *
     * 太他妈难了这块！
     *
     * https://haokan.baidu.com/v?pd=wisenatural&vid=9577557500401627062
     * 我看人家网上写的是三层的,好吧我自己也改良了一下。我看看能省多长时间
     * 额。。。。打脸，写的比插入排序都慢我勒个去！忘掉忘掉好好看人家咋写的。
     *
     * 希尔排序，简单来说就是分组+插入排序。
     *
     * 排序方法有这么多，为什么就选择用插入排序呢？因为插入排序的特性是，复杂度在有序的情况下为O(n).最坏情况下才O(n2).
     * 并且插入排序在总量比较小的情况下表现会比较好。
     * 而希尔排序的分组部分，恰恰就是为了促进无序变有序。所以排序的部分采用的是插入排序。
     * 希尔排序可不能再链式数据结构上计算。链式跳跃着找，老麻烦了。
     * @param data
     */
    private void shellSort(int[] data) {
        int temp;
        for (int step = data.length / 2; step > 0; step /= 2) {
            for (int index = 0; index < data.length; index += step) {
                for (int k = index; k >= 0 && k + step < data.length; k -= step) {
                    if (data[k + step] < data[k]) {
                        temp = data[k + step];
                        data[k + step] = data[k];
                        data[k] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
