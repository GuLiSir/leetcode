//package com.leetcodelib;
//
///**
// * 7. 反转整数
// * 题目地址:https://leetcode-cn.com/problems/reverse-integer/description/
// * <p>
// * 给定一个 32 位有符号整数，将整数中的数字进行反转。
// * <p>
// * 示例 1:
// * <p>
// * 输入: 123
// * 输出: 321
// * 示例 2:
// * <p>
// * 输入: -123
// * 输出: -321
// * 示例 3:
// * <p>
// * 输入: 120
// * 输出: 21
// * 注意:
// * <p>
// * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
// */
//public class ReverseInteger {
//    public static void main(String[] args) {
//        System.out.println(reverse(123));
//        System.out.println(reverse(0));
//        System.out.println(reverse(1));
//        System.out.println("00000");
//    }
//
//    public static int reverse(int x) {
//        int outputNum = 0,mod = 0;
//        int ratio= x;
//        if(Math.abs(ratio) < 10){
//            return x;
//        }
//        while(Math.abs(ratio)>9){
//            mod = ratio%10;
//            ratio = ratio/10;
//            outputNum = outputNum*10 + mod;
//        }
//        return outputNum;
//    }
//}
