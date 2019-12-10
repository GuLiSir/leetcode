package com.leetcodelib.p1200_1299;

/**
 * 1266. 访问所有点的最小时间
 * <p>
 * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
 * <p>
 * 你可以按照下面的规则在平面上移动：
 * <p>
 * 每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[1,1],[3,4],[-1,0]]
 * 输出：7
 * 解释：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * 从 [1,1] 到 [3,4] 需要 3 秒
 * 从 [3,4] 到 [-1,0] 需要 4 秒
 * 一共需要 7 秒
 * 示例 2：
 * <p>
 * 输入：points = [[3,2],[-2,2]]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * points.length == n
 * 1 <= n <= 100
 * points[i].length == 2
 * -1000 <= points[i][0], points[i][1] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-visiting-all-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumTimeVisitingAllPoints {

    public static void main(String[] args) {
        int[][] point = new int[][]{new int[]{1, 1}, new int[]{3, 4}, new int[]{-1, 0}};
        System.out.println(minTimeToVisitAllPoints(point));
    }

    /**
     * 说明:
     * 每次只能上下左右或者斜对角移动,并且都耗时一秒. 那么将斜对角移动分解开来,视为:
     * 1.左右是否需要移动(判断x坐标大小)
     * 2.上下是否需要移动(判断y坐标大小)
     * 在上述两点中,任意一点需要移动记为花费一秒
     */
    public static int minTimeToVisitAllPoints(int[][] points) {
        int step = 0;
        for (int i = 1; i < points.length; i++) {
            int[] pointLast = points[i - 1];
            int[] point = points[i];

            while (pointLast[0] != point[0] || pointLast[1] != point[1]) {
                int xMove = 0;//x轴是否需要移动,正向移动还是反向移动
                if (pointLast[0] < point[0]) {
                    xMove = 1;
                } else if (pointLast[0] > point[0]) {
                    xMove = -1;
                }

                int yMove = 0;//y轴是否需要移动,正向移动还是反向移动
                if (pointLast[1] < point[1]) {
                    yMove = 1;
                } else if (pointLast[1] > point[1]) {
                    yMove = -1;
                }

                //进行移动
                pointLast[0] = pointLast[0] + xMove;
                pointLast[1] = pointLast[1] + yMove;
                step++;//记为花费一秒
            }

        }
        return step;
    }

}
