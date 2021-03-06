package com.example.typeinfo;

import com.example.util.print.Print;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 纸质书340页
 * 动态代理
 * 动态代理奏效的只能是接口中的方法。
 */

class MethodsSelector implements InvocationHandler{
    private Object proxied;

    public MethodsSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if ("interesting".equals(method.getName())) {
            Print.print("找到感兴趣的方法");
        }
        return method.invoke(proxied, objects);
    }
}

interface SomeMethods{
    void boring1();
    void boring2();
    void interesting();
    void boring3();
}

class Implamention implements SomeMethods{
    @Override
    public void boring1() {
        Print.print("boring1");
    }

    @Override
    public void boring2() {
        Print.print("boring2");
    }

    @Override
    public void interesting() {
        Print.print("interesting");
    }

    @Override
    public void boring3() {
        Print.print("boring3");
    }
}

public class SelectingMethods{
    public static void main(String[] args) {
        test(new Implamention());
    }

    public static void test(SomeMethods implamention) {
        // 生成出来的类型必须是接口
        // SomeMethods.class  Implamention.class.getInterfaces() 与 object.getClass().getInterfaces（）出来的结果
        // 不一样，前面两个会报错！
        SomeMethods someMethods = (SomeMethods) Proxy.newProxyInstance(implamention.getClass().getClassLoader(),
                implamention.getClass().getInterfaces(),
                new MethodsSelector(implamention));
        someMethods.boring1();
        someMethods.boring2();
        someMethods.interesting();
        someMethods.boring3();
    }
}
