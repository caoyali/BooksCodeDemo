package com.example.typeinfo;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/**
 * 纸质书330页
 * 递归计数
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;
    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    /**
     * baseType.isAssignableFrom(type) 可以获取两个class之间到底有没有关系。
     * @param obj
     */
    public void count(Object obj) {
        Class<?> type = obj.getClass();
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(obj + " incorrect type: " + type + ", should be type or subtype of baseType!");
        }
        countClass(type);
    }

    private void countClass(Class<?> type){
        Integer quantity = get(type);
        put(type, null == quantity ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        // 此处采用了递归的方式进行计数
        if (null != superClass && baseType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Class <?>, Integer> entry : entrySet()) {
            stringBuilder.append(entry.getKey().getSimpleName())
                    .append("=")
                    .append(entry.getValue())
                    .append(", ");
        }
        return stringBuilder.toString();
    }

}
