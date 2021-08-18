package com.example.array;

import com.example.util.print.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 纸质书 433页
 */
public class AAA_ContainerComparision {

     static class BerylliumSphere {

         /**
          * 这里我产生了一个疑惑，开始我没有将BerylliumSphere 以static修饰，检查出了问题。
          *
          * 我靠我又有一个问题出来了，Android studio 边写代码边检查，这个在专业上是处于什么期啊？
          */
        private static long counter;
        private final long id = counter ++;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"id\":")
                    .append(id);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * List 是可以自动扩容的，并且可以增加容量
     * 但是数组却没那么灵活了！
     *
     * 数组和容器在这本书的定义是不一样的。容器就是Collection旗下的类哈，跟数组不一样。
     * @param args
     */
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }

        // 这种打印的每个元素是对象地址么
        Print.print(Arrays.toString(spheres));
        Print.print(spheres[4]);

        List<BerylliumSphere> sphereList = new ArrayList<>();
        for (int k = 0; k < 5; k++) {
            sphereList.add(new BerylliumSphere());
        }

        // 这种不是只打印对象名么？
        Print.print(sphereList);
        Print.print(sphereList.get(4));

        // 自动包装
        int[] integers = {0, 1, 2, 3, 4};
        Print.print(Arrays.toString(integers));
        Print.print(integers[4]);

        // 注意与前面的区别，这样也是可以的！ 自动拆装箱。
        Integer[] integers1 = {1,2,3,4,5};

        // 这个方法不是很常用，希望记一下
        List<Integer> integersList = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        // 同样是自动拆装箱
        integersList.add(97);

        Print.print(integersList);
        Print.print(integersList.get(4));

        /**
         * 但是不知道有没有注意到，数组根本就没有办法使用泛型！你只能指定一个指定的类型！但是如果泛型机制没有出现
         * 之前，你会发现这样用数组竟然也可以凑活着类型检查。
         */

    }


}
