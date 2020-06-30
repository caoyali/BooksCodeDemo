package com.example.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
    private BufferedReader in;
    public InputFile(String sName) throws Exception{
        try {
            in = new BufferedReader(new FileReader(sName));
            // other code can make exception
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + sName);
            throw e;
        } catch (Exception e) {
            try {
                in.close();
            } catch (IOException e1) {
                System.out.println("in.close() unsuccessful");
            }
            throw e;
        } finally {
            // Don't close here!!!
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
            // 如果调用了一个可能抛出异常的方法，你明明知道它会有异常，是继续向上抛出去还是只是在本层进行处理
            // 或者是直接将一个异常转化另外一个异常，这个纯属设计问题。你爱怎么样就怎么样。
        } catch (IOException e){
            throw new RuntimeException("readLine() failed!");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose successful!");
        } catch (IOException e) {
            throw new RuntimeException("in.close failed!");
        }
    }

}
