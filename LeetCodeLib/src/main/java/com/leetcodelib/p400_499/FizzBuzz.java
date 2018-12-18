package com.leetcodelib;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/description/
 * 412. Fizz Buzz
 * <p>
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>
 * 示例：
 * <p>
 * n = 15,
 * <p>
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class FizzBuzz {
    public static void main(String[] args) {
        List<String> strings = fizzBuzz(15);
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("\n");


        List<String> strings2 = fizzBuzz(500);
        for (String string : strings2) {
            System.out.println(string);
        }

    }

    public static List<String> fizzBuzz(int n) {
        List<String> stringList = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                stringList.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                stringList.add("Fizz");
                continue;
            }
            if (i % 5 == 0) {
                stringList.add("Buzz");
                continue;
            }
            stringList.add(String.valueOf(i));
        }
        return stringList;
    }

}
