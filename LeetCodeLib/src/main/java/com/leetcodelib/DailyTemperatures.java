package com.leetcodelib;

import java.util.ArrayList;
import java.util.List;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/description/
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 */
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
