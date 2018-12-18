//package com.leetcodelib;
//
///**
// * https://leetcode-cn.com/problems/plus-one/description/
// * 66. 加一
// * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
// * <p>
// * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
// * <p>
// * 你可以假设除了整数 0 之外，这个整数不会以零开头。
// * <p>
// * 示例 1:
// * <p>
// * 输入: [1,2,3]
// * 输出: [1,2,4]
// * 解释: 输入数组表示数字 123。
// * 示例 2:
// * <p>
// * 输入: [4,3,2,1]
// * 输出: [4,3,2,2]
// * 解释: 输入数组表示数字 4321。
// */
//public class PlusOne {
//    public static void main(String[] args) {
////        int[] ints = plusOne(new int[]{1, 2, 3});
////        int[] ints = plusOne(new int[]{9});
//        int[] ints = plusOne(new int[]{9,9});
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
//    }
//
//    public static int[] plusOne(int[] digits) {
////        if (digits.length == 1) {
////            digits[0]++;
////            return digits;
////        }
//        return plusOne(digits, digits.length - 1);
//    }
//
//    public static int[] plusOne(int[] digits, int tag) {
//        if (digits[0] == 9 && tag == 0) {
//            digits[0] = 0;
//            int[] digits2 = new int[digits.length + 1];
//            for (int i = 0; i < digits.length; i++) {
//                digits2[i + 1] = digits[i];
//            }
//            digits2[0] = 1;
//            return plusOne(digits2, 1);
//        }
//        for (int i = 0; i < digits.length; i++) {
//            if (i == tag) {
//                if (digits[i] == 9) {
//                    digits[i] = 0;
//                    plusOne(digits, tag - 1);
//                } else {
//                    digits[i] = digits[i] + 1;
//                }
//            }
//        }
//        return digits;
//    }
//}
