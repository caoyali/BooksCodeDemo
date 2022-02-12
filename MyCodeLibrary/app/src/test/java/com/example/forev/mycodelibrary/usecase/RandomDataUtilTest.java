package com.example.forev.mycodelibrary.usecase;

import com.example.forev.mycodelibrary.utils.RandomDataUtil;

import org.junit.Test;

public class RandomDataUtilTest {
    @Test
    public void TestRandomData(){
        int[] re = RandomDataUtil.randomData(10, 5);
        System.out.println(re);
    }
}
