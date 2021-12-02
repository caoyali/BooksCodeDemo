package com.example.class相关类研究;

import com.example.util.print.Print;

public class ClassTTest {

    public static void main(String[] args) {
        ClassTTestCallBack<ClassTTest> callBack = new ClassTTestCallBack<ClassTTest>(ClassTTest.class){
            @Override
            void callback(ClassTTest classTTest) {
                Print.print("测试是不是！");
            }
        };
        callBack.callback(new ClassTTest());
        ClassTTestCallBack<ClassTTest> callBack1 = new ClassTTestCallBack<ClassTTest>(ClassTTest.class) {
            @Override
            void callback(ClassTTest classTTest) {

            }
        };
    }

    abstract static class ClassTTestCallBack<T>{
        private Class<T> clazz;

        public ClassTTestCallBack(Class<T> clazz) {
            this.clazz = clazz;
        }

        abstract void callback(T t);
    }

    interface ClassTTestCallBack2<T extends Class<? extends Object>>{
        abstract void callback(T t);
    }
}
