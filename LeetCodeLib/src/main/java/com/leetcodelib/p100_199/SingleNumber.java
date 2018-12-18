package com.leetcodelib;

/**
 * https://leetcode-cn.com/problems/single-number/description/
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        int i = singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(i);
        int i2 = singleNumber(new int[]{4, 1, 2, 1, 2,4,5,6,5});
        System.out.println(i2);
    }

    /**
     * 思路,由于除了一个元素之外,其他每一个元素都是重复出现了两次,
     * 有相同的两个元素值,可以直接用异或操作,得出结果为0.
     * 所以把数组中所有的都异或一遍,就会只剩下一个只出现一次的没有异或到,
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
