package com.leetcodelib;

/**
 * https://leetcode-cn.com/problems/missing-number/description/
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class MissingNumber {
    public static void main(String[] args) {
        int i = missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
        System.out.println(i);
        System.out.println( missingNumber(new int[]{3,0,1}));
    }

    /**
     * 原理:先求出该数组的总值,
     * 然后利用等差数列求和,得出值,(由条件可得知:A0=0,An=n,n为数组长度+1,因为缺失了一个);
     */
    public static int missingNumber(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total+=nums[i];
        }
        //等差数列求和
        int length = nums.length;
        int i = length * (length+1) / 2;
        return i-total;

    }
}
