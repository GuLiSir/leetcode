package com.leetcodelib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/description/
 * 219. 存在重复元素 II
 * <p>
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsDuplicateIi {

    public static void main(String[] args) {
        int[] int1 = new int[]{1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(int1, 3));
        int[] int2 = new int[]{1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(int2, 1));
        int[] int3 = new int[]{1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(int3, 2));
    }


    /**
     * 解析:
     * 每一位与后面的进行比较,有相同的值就计算相差的长度k.最后一位除外
     * 这个逻辑与217题很像,就是多了差值判断
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //遍历:第0位开始,到倒数第二位
        for (int i = 0; i < nums.length - 1; i++) {
            //当前要对比的值
            int num = nums[i];
            //从当前要对比的位置,直到最后一行
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (num == nums[i1]) {
                    if (Math.abs(i - i1) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
