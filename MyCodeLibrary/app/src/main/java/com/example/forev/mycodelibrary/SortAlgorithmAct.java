package com.example.forev.mycodelibrary;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class SortAlgorithmAct extends BaseActivity {
//    https://www.cnblogs.com/onepixel/articles/7674659.html
    private final static String TAG = "SortAlgorithmAct";
    int[] mNumbers;
    @BindView(R.id.mOriginDataTv)
    TextView mOriginDataTv;
    @BindView(R.id.mResultTv)
    TextView mResultTv;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_sort_algorithm;
    }

    @Override
    protected void initView() {
        //生成若干位随机数
        int count = 9;
        int space = 1000;
        mNumbers = new int[count];
        int n;
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            n = random.nextInt(space);
            mNumbers[i] = n;
        }
        printArray(mNumbers, mOriginDataTv);
    }

    @OnClick({R.id.mPopSort, R.id.mEasySelectSort, R.id.mQuickSort, R.id.mEasyInsertSort, R.id.mShellSort})
    public void onClick(View v) {
        int[] nu1 = Arrays.copyOf(mNumbers, mNumbers.length);
        switch (v.getId()) {
            case R.id.mPopSort:
                popSort(nu1);
                break;
            case R.id.mEasySelectSort:
                selectSort(nu1);
                break;
            case R.id.mQuickSort:
                quickSort1(nu1, 0, mNumbers.length - 1);
                break;
            case R.id.mEasyInsertSort:
                directerInsertSort(nu1);
                break;
            case R.id.mShellSort:
                shellSort(nu1);
                break;
        }
        printArray(nu1, mResultTv);
    }

    private void printArray(int[] numbers, TextView tv){
        if (null == numbers || null == tv){
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < numbers.length; k++){
            builder.append(numbers[k] + ", ");
        }
        tv.setText(builder.toString());
        int color = tv.getCurrentTextColor();
        if (Color.parseColor("#000000") == color) {
            color = Color.parseColor("#FF0000");
        } else {
            color = Color.parseColor("#000000");
        }
        tv.setTextColor(color);
    }

    private String printArray(int[] numbers){
        if (null == numbers){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < numbers.length; k++){
            builder.append(numbers[k] + ", ");
        }
        return builder.toString();
    }

    private String printArray(int[] mNumbers, int start, int end){
        int[] r = Arrays.copyOfRange(mNumbers, start, end + 1);
        return printArray(r);
    }

    /**
     * 交换排序，有个特点，是它并不会引入一个新的数组，而且是经过两两比较之后互换位置，从而得以调整的。
     * 包括冒泡排序，和快速排序。其中快排是一个比较高效的排序方式。
     */
    /**
     * 交换排序--冒泡排序
     * 有小到大
     * 交换排序的一种
     * 两两递增比对，每次都把最大的推到后面去。排上几次就出来结果了。
     * 冒泡排序，复杂度为 n * n-1 * n-2 ...0 为 n!
     * 重点：两两交换,遍历时与周围交换，周围两两是特点
     * @param originNumbers
     * @return
     */
    private void popSort(int[] originNumbers) {
        //拷贝一份，不更改初始值
        for (int i = originNumbers.length - 1; i >= 0; i--) {
            // K + 1 在最后一个的时候正好为 i， 所以此处是小于
            for (int k = 0; k < i; k++) {
                if (originNumbers[k] > originNumbers[k + 1]) {
                    trans(originNumbers, k, k + 1);
                }
            }
        }
        return;
    }

    /**
     * 选择排序--简单选择排序
     * 找出最大的一个，记住索引位置，索引位置哈！等每一趟找出来之后，将这个最大位置的索引位置的数据，与当前趟最后的一个索引数据调换一下，这样就选完了。
     * 完了这个我跟插入排序混了。
     * @param originNumbers
     * @return
     */
    private void selectSort(int[] originNumbers) {
        for (int i = 0; i < originNumbers.length; i ++) {
            int minIndex = i;
            for (int k = i + 1; k < originNumbers.length; k++) {
                if (originNumbers[minIndex] > originNumbers[k]) {
                    minIndex = k;
                }
            }
            trans(originNumbers, i, minIndex);
        }
    }

    /**
     * 快排实现方式1， 这个是我自己的实现方式。
     * 交换排序的一种，也是对冒泡排序的一种改进
     * 其核心原理是不断地分区，假设待比较的是b, 分成某个数的左边的数都小于b, 右边的数都大于b
     *
     * 首先取出一个基准值，一般这个基准值会从第一个位置开始取，我仔细想了一下，这个位置貌似是必须的。应该必须从第一个或者最后一个取
     * 取出基准值的意义何在？
     * 我认为取了基准值之后，会造成这串数据，腾出一个空位，这个空位，就是给代码交换数据用的。
     * 只要新的值落到了空位，那么原来的那个被替代的索引位置立马变成新的空位，以备下一次对比置换。
     *
     * 就这样一直替换，不断产生空位，直到这个空位因为 Start++  end-- 被挤到中间。 最终空位落基准值。一趟排序结束。
     * 接下来就是递归分制了。
     *
     * 8 9 10 2 14 5 7 4
     *
     * 取第一位8作为基准
     *
     *
     *       基准=8
     *
     * 空 9 10 2 14 5 7 4
     * S                E
     *
     * 取E位置
     *
     * E = 4   < 基准值8   需颠倒
     *
     * 4 9 10 2 14 5 7 空
     * S               E
     *
     * S 位置有意义了，报废，S++
     *
     * 4 9 10 2 14 5 7 空
     *   S             E
     *
     * S = 9  > 基准值8   需颠倒
     *
     * 4 空 10 2 14 5 7 9
     *   S             E
     *
     * E 位置有意义了，报废， E--
     *
     * 4 空 10 2 14 5 7 9
     *   S           E
     *
     * E = 7 < 基准值8， 需颠倒
     *
     * 4 7 10 2 14 5 空 9
     *   S           E
     *
     * S 位置有意义了， 报废。 S++
     *
     * 4 7 10 2 14 5 空 9
     *     S         E
     *
     * S = 10 > 基准值8， 需颠倒
     *
     * 4 7 空 2 14 5 10 9
     *     S         E
     *
     * E 位置有意义了， E--
     *
     * 4 7 空 2 14 5 10 9
     *     S      E
     *
     * E = 5 < 基准值8, 需颠倒
     * 4 7 5 2 14 空 10 9
     *     S      E
     *
     * S位置有意义了， S++
     * 4 7 5 2 14 空 10 9
     *       S    E
     *
     * S = 2 < 基准值8，不需要变动  S++
     *
     * 4 7 5 2 14 空 10 9
     *         S  E
     *
     * S = 14 > 基准值8， 需要颠倒
     *
     * 4 7 5 2 空 14 10 9
     *         S  E
     *
     * E位置有意义了， E--
     * 4 7 5 2 空 14 10 9
     *         S
     *         E
     *
     * S == E 了， 将基准值8填入这个空位
     *
     * 4 7 5 2 8 14 10 9
     *
     * 一趟排序结束
     *
     *
     *
     * 上面的链接中的文章很好的解释了一个事情
     * 就是基准值随便找一个。然后从左往右找到第一个大于基准值的数，再从右往左找到第一个小于基准值的数。这两个数相互转换，不久
     * 调成左边小右边大了么。
     *
     * @param originNumbers
     * @return
     */
    private void quickSort(int[] originNumbers, int start, int end) {
        Log.d("丫丫梨快排", "start=" + start + " end=" + end);
        if (null == originNumbers) {
            return;
        }

        if (start >= end) {
            return;
        }

        if (start < 0 || start >= originNumbers.length || end >= originNumbers.length || end < 0) {
            Log.e("丫丫梨快排", "参数出错： originNumbers.length=" + originNumbers.length + " start=" + start + " end=" + end);
            return;
        }

        int originStart = start;
        int originEnd = end;

        int compareNumber = originNumbers[start];
        // 这个参数是我自己加的，不知道对不对。看看网上问么写的吧。
        boolean startIsNull = true;
        while (start < end) {
            if (startIsNull) {
                if (originNumbers[end] > compareNumber) {
                    end --;
                    startIsNull = true;
                } else {
                    originNumbers[start] = originNumbers[end];
                    start ++;
                    startIsNull = false;
                }
            } else {
                if (originNumbers[start] > compareNumber) {
                    originNumbers[end] = originNumbers[start];
                    end --;
                    startIsNull = true;
                } else {
                    start ++;
                    startIsNull = false;
                }
            }
        }

        originNumbers[start] = compareNumber;

        quickSort(originNumbers, originStart, start);
        quickSort(originNumbers, start + 1, originEnd);
    }

    /**
     * 快排实现方式2
     * 这个快速排序更好，这个得记住，比我写的那个好多了呜呜。
     * 其核心是采用了分治法。
     * 但是对于我个人而言，我的重点在于，先腾出一个位置，然后再置换，要不会置换错的。
     * @param originNumbers
     * @param start
     * @param end
     */
    private void quickSort1(int[] originNumbers, int start, int end) {
        if (start >= end) {
            return;
        }
        int center = partSort(originNumbers, start, end);
        quickSort(originNumbers, start, center -1);
        quickSort(originNumbers, center + 1, end);
    }

    /**
     * index 快排的子细节。我发现我自己的思路没有网上大神的思路好。
     * @param originNumbers
     * @param start
     * @param end
     * @return index
     */
    private int partSort(int[] originNumbers, int start, int end) {
        Log.d("丫丫梨快排", "start=" + start + " end=" + end);
        int p = originNumbers[start];
        while (start < end) {
            while (originNumbers[end] >= p) {
                end --;
            }

            originNumbers[start] = originNumbers[end];

            while (originNumbers[start] < p) {
                start ++;
            }
            originNumbers[end] = originNumbers[start];
        }
        originNumbers[start] = p;
        return start;
    }

    private void trans(int[] ints, int position1, int position2) {
        int t = ints[position1];
        ints[position1] = ints[position2];
        ints[position2] = t;
    }

    /**
     * 简单插入排序。
     *
     * 基本思想：
     　　把n个待排序的元素看成一个有序表和一个无序表，开始时有序表中只有一个元素，无序表中有n-1个元素；
        排序过程即每次从无序表中取出第一个元素，将它插入到有序表中，使之成为新的有序表，重复n-1次完成整个排序过程。
        类似于，玩牌的时候，每次拿到新的牌，之后就将这个新牌插入到合适的位置，也就是现拿现排序
     　实例：
     　　0.初始状态 3，1，5，7，2，4，9，6（共8个数）
     　　   有序表：3；无序表：1，5，7，2，4，9，6
     　　1.第一次循环，从无序表中取出第一个数 1，把它插入到有序表中，使新的数列依旧有序
     　　   有序表：1，3；无序表：5，7，2，4，9，6
     　　2.第二次循环，从无序表中取出第一个数 5，把它插入到有序表中，使新的数列依旧有序
     　　   有序表：1，3，5；无序表：7，2，4，9，6
     　　3.第三次循环，从无序表中取出第一个数 7，把它插入到有序表中，使新的数列依旧有序
     　　   有序表：1，3，5，7；无序表：2，4，9，6
     　　4.第四次循环，从无序表中取出第一个数 2，把它插入到有序表中，使新的数列依旧有序
     　　   有序表：1，2，3，5，7；无序表：4，9，6
     　　5.第五次循环，从无序表中取出第一个数 4，把它插入到有序表中，使新的数列依旧有序
     　　   有序表：1，2，3，4，5，7；无序表：9，6
     　　6.第六次循环，从无序表中取出第一个数 9，把它插入到有序表中，使新的数列依旧有序
     　　   有序表：1，2，3，4，5，7，9；无序表：6
     　　7.第七次循环，从无序表中取出第一个数 6，把它插入到有序表中，使新的数列依旧有序
     　　   有序表：1，2，3，4，5，6，7，9；无序表：（空）

     那么问题来了，这会导致不断的插入数据，一个位置被插入，所有的index都得变啊，怎么回事。
     简单插入排序简单个鬼啊，一点都不简单。
     * @param ints
     */
    private void directerInsertSort(int[] ints) {
        long startTime = System.currentTimeMillis();
        int temp;
        for (int i = 0; i < ints.length - 1; i ++) {
            temp = ints[i + 1];
            if (temp < ints[i]) {
                // 发现新的数，比之前的数小。往前找，替换。
                for (int k = i; k > 0; k --) {
                    if (ints[k - 1] < temp && temp < ints[k]) {
                        // 从 i + 1 到 k， 全部换

                    }
                }
            } else {
                continue;
            }
        }
        Log.d("丫丫梨", "直接插入排序用时: " + (System.currentTimeMillis() - startTime));
    }

    /**
     * 希尔排序
     * 是对简单插入排序的一种优化。
     * 简单插入排序的稳定性和数组里面的 内容有很大的关系。如果里面的内容本就是从小到大的，那么涉及到的数据交换的次数就非常少。
     * 但是如果是从大到小倒序排列的话。数据交换的次数就会上升。所以目前看来，数据本身是否是有序，是影响简单插入排序性能的关键。
     * 希尔排序的优化之处主要就是，把本来不是有序的数据，先改为相对有序，最后再进行插入排序，
     *
     *
     * @param ints
     */
    private void shellSort(int[] ints) {
        long startTime = System.currentTimeMillis();
        int length = ints.length;
        int minTemp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i ++) {
                minTemp = ints[step];
                int j = i - step;
                while (j >= 0 && ints[j] > minTemp) { // 前面的数大于后面的数
                    ints[j + step] = ints[j];
                    j -= step;
                }
                ints[j + step] = minTemp;
            }
        }
        Log.d("丫丫梨", "希尔分区对比完: " + (System.currentTimeMillis() - startTime));
    }

    public static void shellSort1(int[] arr) {
        long startTime = System.currentTimeMillis();
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            Log.d("丫丫梨", "step=" + step);
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                Log.d("丫丫梨", "循环j=" + j);
                while (j >= 0 && arr[j] > temp) {
                    Log.d("丫丫梨", "三层循环j=" + j + " j + step=" + (j + step));
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
        Log.d("丫丫梨", "希尔分区对比完: " + (System.currentTimeMillis() - startTime));
    }
}
