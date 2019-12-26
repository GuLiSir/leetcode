package com.leetcodelib.p1200_1299;

/**
 * 1295. 统计位数为偶数的数字
 * <p>
 * <p>
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数） 
 * 345 是 3 位数字（位数为奇数）  
 * 2 是 1 位数字（位数为奇数） 
 * 6 是 1 位数字 位数为奇数） 
 * 7896 是 4 位数字（位数为偶数）  
 * 因此只有 12 和 7896 是位数为偶数的数字
 * 示例 2：
 * <p>
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 * 解释：
 * 只有 1771 是位数为偶数的数字。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindNumbersWithEvenNumberOfDigits {


    public static void main(String[] args) {

//        int[] ints = new int[]{12, 345, 2, 6, 7896};
        int[] ints = new int[]{580,317,640,957,718,764};
        System.out.println(findNumbers(ints));
    }


    /**
     * 遍历,统计每一个数是否为偶位数.
     * 统计方法,判断位数为奇偶情况,也就是每次除以10;直到结果为0
     */
    public static int findNumbers(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int a = 0;
            while (num / 10 != 0||num % 10 != 0) {
                num = num / 10;
                a++;
            }
            if (a % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}
