package com.leetcodelib;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 * 217. 存在重复元素
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] int1 = new int[]{1, 2, 3, 4};
        System.out.println(containsDuplicate(int1));
        int[] int2 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(int2));
    }

    /**
     * 先对数字进行排序,这样如果有相同的值,那么肯定会有相邻的两个值相同
     */
    public static boolean containsDuplicate(int[] nums) {
        List<Integer> integerList = new ArrayList<>(nums.length);
        for (int num : nums) {
            integerList.add(num);
        }
        integerList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });

        //从0到(n-1)进行向后一位对比
        for (int i = 0; i < integerList.size() - 1; i++) {
            if (((int) integerList.get(i)) == integerList.get(i + 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解析:
     * 每一位与后面的进行比较,有相同的值就返回true.最后一位除外
     * 这种方法可行,但是会超时.
     */
    public static boolean containsDuplicate1(int[] nums) {
        //遍历:第0位开始,到倒数第二位
        for (int i = 0; i < nums.length - 1; i++) {
            //当前要对比的值
            int num = nums[i];
            //从当前要对比的位置,直到最后一行
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (num == nums[i1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
