package com.example.pattern.InterpreterPattern.demo1;

import java.util.Stack;

class InterpreterHelper {
    public static int addAndSub(String str) {
        System.out.println("计算str=" + str);
        Stack<IOperation> operations = new Stack<>();
        char tempChar;
        int i = 0;
        while (i < str.length()) {
            tempChar = str.charAt(i);
            System.out.println("现在遍历到的参数是 tempChar=" + tempChar);
            if ('+' == tempChar) {
                // i= 1；
                IOperation old = operations.pop();
                if (i + 1 < str.length()) {
                    int ind = findNextOptionIndex(str, i + 1);
                    IOperation nextValue = new Value(getSubNextNumber(str, i + 1, ind));
                    AddOperation addOperation = new AddOperation(old, nextValue);
                    operations.push(addOperation);
                    i = ind;
                } else {
                    break;
                }
            } else if ('-' == tempChar) {
                IOperation old = operations.pop();
                if (i + 1 < str.length()) {
                    int ind = findNextOptionIndex(str, i + 1);
                    IOperation nextValue = new Value(getSubNextNumber(str, i + 1, ind));
                    SubOperation addOperation = new SubOperation(old, nextValue);
                    operations.push(addOperation);
                    i = ind;
                } else {
                    break;
                }
            } else {
                //普通数字
                int ind = findNextOptionIndex(str, i);
                IOperation value = new Value(getSubNextNumber(str, i, ind));
                operations.push(value);
                i = ind;
            }
        }

        int result = operations.pop().operate();
        return result;
    }

    public static int getSubNextNumber(String str, int start, int end) {
        String sub = str.substring(start, end);
        System.out.println("截取数字：" + sub);
        return Integer.parseInt(sub);
    }

    public static int findNextOptionIndex(String str, int startIndex) {
        while (startIndex < str.length()) {
            char c = str.charAt(startIndex);
            if ('-' == c || '+' == c) {
                break;
            }
            startIndex ++;
        }
        System.out.println("str=" + str + " 下一个操作符坐标=" + startIndex);
        return startIndex;
    }
}
