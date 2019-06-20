package com.leetcodelib.p500_599;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 * <p>
 * https://leetcode-cn.com/problems/array-partition-i/
 * <p>
 * <p>
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,4,3,2]
 * <p>
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 * <p>
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 */
public class ArrayPartitionI {

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(arrayPairSum(new int[]{7, 3, 1, 0, 0, 6}));
//        System.out.println(arrayPairSum( new int[]{1,4,3,2} ));
    }

    /**
     * 思路:
     * 既然是拆分成两个一组,然后又要一组中取最小值之和结果最大,也就是说,一组之中会有最大的那个数会被去掉,
     * 此数浪费,也就是一组中两数越接近,则被去掉的值越少.例如[1,2,99,100],进行计算的话,取[1,100]+[2,99],
     * 则100和99都被浪费掉了,造成结果为3. 取[1,2]+[99,100],这样,结果为100.
     * 所以这种可以先进行排序,然后再两两一组,得到结果最大
     */
    public static int arrayPairSum(int[] nums) {
        int length = nums.length;
        if (length / 2 == 1 && length > 2) {
            throw new IllegalArgumentException("数组长度不能为奇数");
        }
        sort(nums);
        int result = 0;
        //遍历的时候步长为2
        for (int i = 0; i < nums.length; i = i + 2) {
            result += Math.min(nums[i], nums[i + 1]);
        }
        return result;
    }

    private static void sort(int[] aa) {
        if (aa.length > 1) {
            for (int i = 1; i < aa.length; i++) {
                int index = i;
                while (index > 0 && aa[index] < aa[index - 1]) {
                    //交换
                    int tmp = aa[index];
                    aa[index] = aa[index - 1];
                    aa[index - 1] = tmp;

                    index--;
                }

            }
        }
    }

}
