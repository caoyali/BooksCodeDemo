package com.example.forev.mycodelibrary.usecase;

import android.util.Log;

import com.example.forev.mycodelibrary.utils.RandomDataUtil;

import org.junit.Test;

public class RandomDataUtilTest {
    @Test
    public void testRandomData(){
        int[] re = RandomDataUtil.randomData(10, 5);
        Log.d("丫丫梨", "re=" + re);
    }
}
