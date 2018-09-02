package com.leetcodelib;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones/description/
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int maxConsecutiveOnes = findMaxConsecutiveOnes(new int[]{1, 1, 0, 0, 1, 1, 1});
        System.out.println(maxConsecutiveOnes);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        //最大的连续数
        int result = 0;
        //当前指的位置是否为1,如果是开头或者,为0,则为false
        boolean find = false;
        //为1的计数
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                find = true;
                count++;
            } else {
                find = false;
                count = 0;
            }
            result = Math.max(result, count);
        }
        return result;
    }

}
