package com.leetcodelib;

/**
 * 7. 反转整数
 * 题目地址:https://leetcode-cn.com/problems/reverse-integer/description/
 * <p>
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class ReverseInteger {
    public static void main(String[] args) {

    }

    public int reverse(int x) {
        String valueOf = String.valueOf(x);
        String result = "";

        for (int length = valueOf.length(); length > 0; length--) {
//            result+=valueOf.(length);
        }
        return 0;
    }
}
