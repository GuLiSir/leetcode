package com.leetcodelib.p1400_1499;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shuffle-the-array/
 * <p>
 * 1470. 重新排列数组
 * <p>
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-the-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(Arrays.toString(shuffle(input, 4)));
    }

    /**
     * 说明:直接遍历添加到结果,遍历的时候需要注意的是索引i需要除以2
     */
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = nums[i / 2];
            } else {
                result[i] = nums[i / 2 + n];
            }
        }
        return result;
    }

}
