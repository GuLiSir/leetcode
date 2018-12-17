package com.leetcodelib.p900_999;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 * <p>
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 2, 4};
        int[] ints = sortArrayByParity(a);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 因为不强调顺序,所以可以直接遍历的;
     * 首先设置两个变量,用作前/后插入的指引位置,
     * 遍历数组,当偶数的时候在前面插入,并且索引自增1;奇数的时候,在后面插入,并且索引自减1
     * @param A
     * @return
     */
    public static int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int index2 = 0;//偶数的索引
        int index1 = A.length - 1;//奇数的索引
        for (int i : A) {
            int i1 = i % 2;
            if (i1 == 0) {
                //偶数,在前面添加
                result[index2] = i;
                index2++;
            } else {
                //奇数,从后面往前添加
                result[index1] = i;
                index1--;
            }
        }

        return result;
    }

}
