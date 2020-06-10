package com.example.exceptions;

import com.example.util.print.Print;

/**
 * 电子书 336页
 */
public class MultipleReturns {
    public static void f(int i) {
        Print.print("Initialization that requires cleanup");
        try {
            Print.print("Point 1");
            if (i == 1) {
                return;
            }
            Print.print("Point 2");
            if (i == 2) {
                return;
            }
            Print.print("Point 3");
            if (i == 3) {
                Print.print("End");
                return;
            }
        } finally {
            // 从打印中是可以看出的，即使return了，最终依然会执行finally块中的代码
            Print.print("Performing cleanup");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            f(i);
        }
    }
}
