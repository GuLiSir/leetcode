package com.leetcodelib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 * 349. 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] ints = new int[]{4, 9, 5};
        int[] ints2 = new int[]{9, 4, 9, 8, 4};
        int[] intersection = intersection(ints, ints2);
        System.out.println(Arrays.toString(intersection));
    }

    /**
     * 一个个数组,遍历,然后第二个数组也进行遍历,在内层.
     * 但是这种复杂度会随规模增大而增大.
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        //外层遍历
        for (int i : nums1) {
            //内层遍历(可优化,用数量少的数组作为外层遍历会好一点,这样执行的次数会少一点)
            for2:
            for (int i1 : nums2) {
                //判断是否为交集
                if (i == i1) {
                    //过滤掉当前已经有的集合
                    for (Integer integer : result) {
                        if (integer == i) {
                            break for2;
                        }
                    }
                    result.add(i);
                    break;
                }
            }
        }
        //返回结果
        int[] oo = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            oo[i] = result.get(i);
        }
        return oo;
    }
}
