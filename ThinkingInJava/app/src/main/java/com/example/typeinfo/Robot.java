package com.example.typeinfo;

import java.util.List;

public interface Robot {
    String name();
    String model();
    List<Operation> operations();

    /**
     * 接口里面是可以有内部类的吗，傻了，我没这么用过！
     */
    class Test{
        public static void test(Robot robot) {

        }
    }
}
