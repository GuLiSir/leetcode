package com.leetcodelib.p400_499;

/**
 * https://leetcode-cn.com/problems/island-perimeter/
 * 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * <p>
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 * <p>
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class IslandPerimeter {

    public static void main(String[] args) {
//        [[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
        int[][] ints = new int[4][4];
        ints[0] = new int[]{0, 1, 0, 0};
        ints[1] = new int[]{1, 1, 1, 0};
        ints[2] = new int[]{0, 1, 0, 0};
        ints[3] = new int[]{1, 1, 0, 0};
        int i = islandPerimeter(ints);
        System.out.println(i);//16
    }

    /**
     * 分析:将岛屿的周长分别拆开来算,分别是判断每一个岛屿的左边,右边,顶边,底边的周长是否存在的情况;
     * 存在就自增即可
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        int result = 0;
        int lengthLine = grid.length;
        for (int i = 0; i < lengthLine; i++) {
            int[] ints = grid[i];
            int length = ints.length;
            for (int i1 = 0; i1 < length; i1++) {
                int anInt = ints[i1];
                if (anInt == 1) {
                    //该位置为岛屿,开始计算周长

                    //左侧是否存在边长判断
                    if (i1 == 0) {
                        //岛屿在最左一列,左边肯定存在边长
                        result++;
                    } else {
                        if (ints[i1 - 1] != 1) {
                            //岛屿左侧为湖水,也是存在边长
                            result++;
                        }
                    }

                    //右侧是否存在边长判断
                    if (i1 == length - 1) {
                        //岛屿在最右一列,左边肯定存在边长
                        result++;
                    } else {
                        if (ints[i1 + 1] != 1) {
                            //岛屿右侧为湖水,也是存在边长
                            result++;
                        }
                    }

                    //顶部是否存在边长判断
                    if (i == 0) {
                        //岛屿在最顶一行,顶边肯定存在边长
                        result++;
                    } else {
                        if (grid[i - 1][i1] != 1) {
                            //岛屿顶部为湖水,也是存在边长
                            result++;
                        }
                    }

                    //底部是否存在边长判断
                    if (i == lengthLine - 1) {
                        //岛屿在最底部一行,底边肯定存在边长
                        result++;
                    } else {
                        if (grid[i + 1][i1] != 1) {
                            //岛屿底部为湖水,也是存在边长
                            result++;
                        }
                    }


                }
            }
        }
        return result;
    }
}
