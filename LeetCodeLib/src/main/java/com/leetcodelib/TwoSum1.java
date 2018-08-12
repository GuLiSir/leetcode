package com.leetcodelib;

/**
 * 第一题,两数之和;
 * 地址:https://leetcode-cn.com/problems/two-sum/description/
 * 题目内容:
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        System.out.print(ints.toString());
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {
                for (int i1 = i + 1; i1 < nums.length; i1++) {
                    if (nums[i] + nums[i1] == target) {
                        return new int[]{i, i1};
                    }
                }
            }
        }
        return null;
    }
}
