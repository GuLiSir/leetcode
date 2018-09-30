package com.leetcodelib;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/description/
 * 169. 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] ints = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(ints));
    }

    /**
     * 简述：
     * 利用map来对每一个元素出现的次数进行统计。如果map不存在，则肯定是第一次出现，
     * 若存在，则次数+1；
     * 当然用integer来实现好像是key太大的时候会有问题，大于128的时候？
     *
     */
    public static int majorityElement(int[] nums) {
        float i = nums.length / 2.0f;
        //map的key为该数组的元素集合，value为该元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer == null) {
                integer = 1;
                map.put(num, 1);
            } else {
                integer = integer + 1;
                map.put(num, integer);
            }

            if (integer > i) {
                return num;
            }

        }
        return -1;
    }

}
