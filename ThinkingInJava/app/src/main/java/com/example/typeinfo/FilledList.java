package com.example.typeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caoyali
 * @date 20200512
 * 纸质书 321页
 */
class CountedInteger {
    private static long counter;
    private final long id = counter ++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}
public class FilledList<T> {
    // 当泛型作用于Class对象的时候，会发生一个很有趣的现象，就是调用newInstance产生的对象就是这里的T类型的对象。很确切！
    private Class<T> type;
    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int mElements) {
        List<T> result = new ArrayList<>();
        try {
            for(int i = 0; i < mElements; i++){
                //Class newInstance方法只是适用于构造方法无参数的情况下使用。如果有参数的情况，可能代码就是另外一种情况了。
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.print(fl.create(15));
    }
}
