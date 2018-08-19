package com.leetcodelib;

import java.util.ArrayList;
import java.util.List;

/**
 * 9. 回文数\
 * https://leetcode-cn.com/problems/palindrome-number/
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeNumber {
    public static void main(String[] args) {

        if (!isPalindrome(121)) {
            throw new RuntimeException();
        }
        if (isPalindrome(-121)) {
            throw new RuntimeException();
        }
        if (!isPalindrome(12321)) {
            throw new RuntimeException();
        }
    }


    public static boolean isPalindrome(int x) {
        if (x < 0) {
            //负数不属于回文数
            return false;
        }
        //不对传入参数做改变,另外起变量
        int y = x;
        List<Integer> integers = new ArrayList<>();
        while ((y / 10) != 0) {
            //当前位数的值
            int i = y % 10;
            integers.add(i);
            y = y / 10;
        }
        //到这里y小于10,代表x最高位的值
        integers.add(y);

        for (int i = 0; i < integers.size(); i++) {
            //回文数判断,第一个和最后一个对比,以此类推,上行循环是可以优化的,就是只对比改数组长度的一半即可,不过要进行奇偶判断
            if (integers.get(i) != integers.get(integers.size() - i - 1)) {
                return false;
            }
        }

        return true;
    }

}
