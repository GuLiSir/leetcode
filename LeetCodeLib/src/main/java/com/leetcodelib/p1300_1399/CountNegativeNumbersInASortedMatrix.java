package com.leetcodelib.p1300_1399;

/**
 * https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * <p>
 * 1351. 统计有序矩阵中的负数
 * <p>
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 * <p>
 * 请你统计并返回 grid 中 负数 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 * <p>
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：grid = [[-1]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */
public class CountNegativeNumbersInASortedMatrix {

    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[]{4, 3, 2, -1}, new int[]{3, 2, 1, -1},
                new int[]{1, 1, -1, -2}, new int[]{-1, -1, -2, -3}};
        System.out.println(countNegatives(grid));
    }

    /**
     * 暴力遍历法，不过既然是非递增顺序的，就说明可能是平序或者是降序的，在后一层遍历的时候，从后往前遍历，可以节约一点性能消耗
     */
    public static int countNegatives(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int length = ints.length; length > 0; length--) {
                if (ints[length-1]<0) {
                    result++;
                }else {
                    break;
                }
            }
        }
        return result;
    }


}
