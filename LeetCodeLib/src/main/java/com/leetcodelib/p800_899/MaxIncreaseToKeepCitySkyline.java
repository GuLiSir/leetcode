package com.leetcodelib.p800_899;

import java.util.HashMap;
import java.util.Map;

/**
 * 807. 保持城市天际线
 * https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
 * <p>
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
 * <p>
 * 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。
 * <p>
 * 建筑物高度可以增加的最大总和是多少？
 * <p>
 * 例子：
 * 输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * 输出： 35
 * 解释：
 * The grid is:
 * [ [3, 0, 8, 4],
 * [2, 4, 5, 7],
 * [9, 2, 6, 3],
 * [0, 3, 1, 0] ]
 * <p>
 * 从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
 * 从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
 * <p>
 * 在不影响天际线的情况下对建筑物进行增高后，新数组如下：
 * <p>
 * gridNew = [ [8, 4, 8, 7],
 * [7, 4, 7, 7],
 * [9, 4, 8, 7],
 * [3, 3, 3, 3] ]
 * 说明:
 * <p>
 * 1 < grid.length = grid[0].length <= 50。
 * grid[i][j] 的高度范围是： [0, 100]。
 * 一座建筑物占据一个grid[i][j]：换言之，它们是 1 x 1 x grid[i][j] 的长方体。
 */
public class MaxIncreaseToKeepCitySkyline {
    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[]{3, 0, 8, 4}, new int[]{2, 4, 5, 7}, new int[]{9, 2, 6, 3}, new int[]{0, 3, 1, 0}};
        int i = maxIncreaseKeepingSkyline(grid);
        System.out.println(i);//35
    }

    /**
     * 解析,根据题目的意思,可知顶部底部看的结果是一样的,左侧右侧看到的结果也是一样的.
     * 反映到数组上,就是一数组的元素最大的值,或者同一索引的最大值就是顶部或者左侧的天际线.
     * 所以当前需要的工作就是找到天际线,然后在对某一个元素求增加量的时候,就直接对于顶部和左侧进行天际线匹配,取最小值就行了.
     * 例如第一个位置int[0][0]为3层,则该行最大的层数为8,改列最大的天际线层数为9,也就是说,只能最大增加五层,才能保持天际线不变.因为不能超过8
     *
     * @param grid
     * @return
     */
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;//数组元素数量
        if (length <= 1) {
            throw new IllegalArgumentException();
        }


        Map<Integer, Integer> integerMap1 = new HashMap<>(length);
        //找到该行的最大数量,得出的map所对应的也就是从左侧看到的天际线
        for (int i = 0; i < length; i++) {
            int[] ints = grid[i];
            int max = 0;
            for (int anInt : ints) {
                max = Math.max(max, anInt);
            }
            integerMap1.put(i, max);
        }


        //找到该列的最大数量,得到的结果就是从底部或者顶部看到的天际线
        int lengthRow = grid[0].length;
        Map<Integer, Integer> integerMap2 = new HashMap<>(lengthRow);
        for (int i = 0; i < lengthRow; i++) {
            int max = 0;
            for (int i1 = 0; i1 < length; i1++) {
                if (grid[i1].length != lengthRow) {
                    throw new IllegalArgumentException("每一行的长度不一致");
                }
                max = Math.max(grid[i1][i], max);
            }
            integerMap2.put(i, max);
        }

        int result = 0;
        //对每一个元素进行天际线计算
        for (int i = 0; i < length; i++) {
            int[] ints = grid[i];
            int length1 = ints.length;
            for (int iChild = 0; iChild < length1; iChild++) {
                //当前楼层数
                int anInt = ints[iChild];
                //该行最高的楼层数
                Integer integer = integerMap1.get(i);
                //该列最高的楼层数
                Integer integer1 = integerMap2.get(iChild);
                //最低天际线,该行和该列取最低的楼层,才能保证天际线不会变化
                int miniLine = Math.min(integer,integer1);
                //最低的减去当前楼层数,得出的可以进行增加的楼层数,并且对结果进行累加
                result +=(miniLine-anInt);
            }
        }

        return result;
    }
}
