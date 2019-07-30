package com.leetcodelib.p00_99;

/**
 * 59. 螺旋矩阵 II
 * <p>
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrixIi {

    public static void main(String[] args) {
        int[][] ints = generateMatrix(4);
        for (int i = 0; i < ints.length; i++) {
            StringBuilder line = new StringBuilder();
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                line.append(ints[i][i1]).append(",");
            }
            System.out.println(line);
        }

    }


    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int size = n * n;
        //定义四个边界
        int left = 0, right = n, top = 0, bottom = n;
        //方向,1:从左往右,2:从上往下,3:从右往左,4:从下往上
        int state = 1;
        //当前位置
        int x = 0, y = 0;
        for (int i = 0; i < size; i++) {
            //写入数值
            result[y][x] = i+1;

            //移动下一个位置
            switch (state) {
                case 1://从左往右
                    if (x < right-1) {
                        x++;
                    } else if (x == right-1) {
                        //到达右边界,方向变为从上到下
                        state = 2;
                        y++;
                        right--;
                    }
                    break;
                case 2: //从上往下
                    if (y < bottom-1) {
                        y++;
                    } else if (y == bottom-1) {
                        //到达下边界,方向变为从右往左
                        state = 3;
                        x--;
                        bottom--;
                    }
                    break;
                case 3://从右往左
                    if (x > left) {
                        x--;
                    } else if (x == left) {
                        //到达左边界,方向变为从下到上
                        state = 4;
                        y--;
                        left++;
                    }
                    break;
                case 4://从下往上
                    if (y > top+1) {
                        y--;
                    } else if (y == top+1) {
                        //到达上边界,方向变为从左往右
                        state = 1;
                        x++;
                        top++;
                    }
                    break;
                default:
                    throw new RuntimeException();
            }

        }
        return result;
    }


}
