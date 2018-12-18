package com.leetcodelib;

/**
 * https://leetcode-cn.com/problems/toeplitz-matrix/description/
 * 766. 托普利茨矩阵
 * <p>
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 * <p>
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,2,3,4],
 * [5,1,2,3],
 * [9,5,1,2]
 * ]
 * 输出: True
 * 解释:
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是True。
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,2],
 * [2,2]
 * ]
 * 输出: False
 * 解释:
 * 对角线"[1, 2]"上的元素不同。
 * 说明:
 * <p>
 * matrix 是一个包含整数的二维数组。
 * matrix 的行数和列数均在 [1, 20]范围内。
 * matrix[i][j] 包含的整数在 [0, 99]范围内。
 * 进阶:
 * <p>
 * 如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？
 * 如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？
 */
public class ToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 1, 2, 3},
                new int[]{9, 5, 1, 2}
        };
        System.out.println(isToeplitzMatrix(matrix));

        int[][] matrix1 = new int[][]{
                new int[]{1, 2},
                new int[]{2, 2}
        };
        System.out.println(isToeplitzMatrix(matrix1));

    }


    /**
     * 思路:
     * 对于每一行,判断每一个与其下一行的下一个是否有相同的值,
     * 当然,最后一行和最后一列除外
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int length = matrix.length;
        //遍历每一行,最后一行除外,因为最后一行没有右下角的元素
        for (int i = 0; i < length - 1; i++) {
            int[] matrix1 = matrix[i];
            //遍历每一行的每一个元素,当然最后一位除外,因为最后一个是没有右下角的元素
            for (int i1 = 0; i1 < matrix1.length - 1; i1++) {
                if (matrix1[i1] != matrix[i + 1][i1+1]) {
                    return false;
                }
            }
        }
        return true;
    }

}
