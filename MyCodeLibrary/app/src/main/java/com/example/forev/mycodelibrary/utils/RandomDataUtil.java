package com.example.forev.mycodelibrary.utils;

import java.util.Random;

public class RandomDataUtil {
    public static int[] randomData(int numberCount, int randomSpace) {
        int[] numbers = new int[numberCount];
        int n;
        Random random = new Random();
        for (int i = 0; i < numberCount; i++) {
            n = random.nextInt(randomSpace);
            numbers[i] = n;
        }
        return numbers;
    }
}
