package com.leetcodelib;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/plus-one/description/
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public static void main(String[] args) {
//        int[] ints = plusOne(new int[]{1, 2, 3});
//        int[] ints = plusOne(new int[]{9});
//        int[] ints = plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        int[] ints = plusOne(new int[]{9});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 思路:
     * 数组可能很大很大,所以不应该转为int 或者long的形式自增1再转为数组,如果这样做可能会溢出.
     * 考虑直接暴力进行解题
     */
    public static int[] plusOne(int[] digits) {

        int addIndex = digits.length - 1;//自增位的索引,从最后一位考虑自增

        while (true) {
            if (digits[addIndex] == 9) {
                //自增位是9,需要进位
                digits[addIndex] = 0;
                addIndex--;
                if (addIndex == -1) {
                    //都已经加到最前面了,需要数组扩容一位,然后旧内容复制到新数组上
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    for (int i = 0; i < newDigits.length - 1; i++) {
                        newDigits[i + 1] = digits[i];
                    }
                    digits = newDigits;
                    break;
                }
            } else {
                //自增完成
                digits[addIndex]++;
                break;
            }
        }
        return digits;
    }

}
