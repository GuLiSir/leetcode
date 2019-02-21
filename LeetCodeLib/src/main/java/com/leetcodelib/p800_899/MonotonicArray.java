package com.leetcodelib.p800_899;

/**
 * 896. 单调数列
 * <p>
 * https://leetcode-cn.com/problems/monotonic-array/
 * <p>
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * <p>
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * <p>
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：[1,1,1]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
public class MonotonicArray {

    public static void main(String[] args) {
        int[] ints1 = new int[]{1, 2, 2, 3};//T
        int[] ints2 = new int[]{6, 5, 4, 4};//T
        int[] ints3 = new int[]{1, 3, 2};//F
        int[] ints4 = new int[]{1, 2, 4, 5};//T
        int[] ints5 = new int[]{1, 1, 1};//T
        System.out.println(isMonotonic(ints1));
        System.out.println(isMonotonic(ints2));
        System.out.println(isMonotonic(ints3));
        System.out.println(isMonotonic(ints4));
        System.out.println(isMonotonic(ints5));
    }

    /**
     * 解析:
     * 可以在刚开始的前几位判断出单调类型,一般都是在数组的第1  2的元素判断出来.
     * 然后对后面的逐一判断,若判断到与当前单调类型相反,则直接返回结果,通过检测则返回true;
     */
    public static boolean isMonotonic(int[] A) {
        //单调类型,大于0为单调递增,小于0为单调递减,等于0为初始值
        int monotonicType = 0;
        for (int i = 1; i < A.length; i++) {
            if (monotonicType == 0) {
                //当前没有单调类型,判断出单调类型,直接相减可得出结果
                monotonicType = A[i] - A[i - 1];
                continue;
            }

            //单调递增的情况
            if (monotonicType >= 0) {
                if (A[i] < A[i - 1]) {
                    //递增情况后者不可能小于前者,否则直接返回false(根据题意的示例,数值相同视为递增)
                    return false;
                }
            }
            //单调递减的情况
            if (monotonicType < 0) {
                if (A[i] > A[i - 1]) {
                    //递减情况后者不可能大于前者,否则直接返回false
                    return false;
                }
            }

        }


        return true;
    }


}
