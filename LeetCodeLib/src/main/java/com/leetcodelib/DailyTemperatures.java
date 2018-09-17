package com.leetcodelib;

import java.util.ArrayList;
import java.util.List;

public class DailyTemperatures {
    public static void main(String[] args) {
//        int[] input = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] input = new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] ints = dailyTemperatures(input);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int count = 1;
            for (int i1 = i + 1; i1 < temperatures.length; i1++) {
                if (temperatures[i] < temperatures[i1]) {
                    result[i] = count;
                    break;
                } else {
                    count++;
                }
                //不用进行末尾判断,因为默认值是0
            }
        }
        return result;
    }
}
