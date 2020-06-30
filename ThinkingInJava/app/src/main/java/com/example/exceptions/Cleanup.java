package com.example.exceptions;

public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile inputFile = new InputFile("Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = inputFile.getLine()) != null);
            } catch (Exception e) {
                System.out.println("Caught Exception in main!");
                e.printStackTrace();
            } finally {
                // dispose在这里调用，而不是在外面的那个catch里面调用。原因是，当InputFile()在初始化
                // 的时候发生异常，我们大可不必dispose，因为此时根本就没有开启资源！
                inputFile.dispose();
            }
        } catch (Exception e) {
//            new InputFile() 可能会引发异常，是在这里进行捕获的
            System.out.println("");
            e.printStackTrace();
        }
    }
}
