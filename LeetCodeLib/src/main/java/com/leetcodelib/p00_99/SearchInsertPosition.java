package com.leetcodelib.p00_99;

/**
 * 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(ints, 2));
    }


    /**
     * 暴力法,效率比较低
     */
//    public static int searchInsert(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target || nums[i] > target) {
//                return i;
//            }
//        }
//
//        return nums.length;
//    }

    /**
     * 二分查找法  效率会高一点
     */
    public static int searchInsert(int[] nums, int target) {

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int cen = (end + start) / 2;
            if (nums[cen] == target) {
                return cen;
            } else if (nums[cen] < target) {
                start = cen+1;
            } else {
                end = cen-1;

            }
        }

        return start;
    }



}
