package com.leetcodelib.p900_999;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * <p>
 * <p>
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] input = new int[]{-4, -1, 0, 3, 10};
        int[] ints = sortedSquares(input);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 直接先平方,然后对结果进行排序
     * @param A
     * @return
     */
    public static int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = A[i]*A[i];
        }

        sort(result);

        return result;


    }


    /**
     * 排序数组,从小到大排序
     * @param aa
     */
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
