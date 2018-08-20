package com.leetcodelib;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 * 26. 删除排序数组中的重复项
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(ints);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int result = 0;
        int integerCurrent = -1;
        for (int num : nums) {
            if (result == 0) {
                //给第一个赋值
                integerCurrent = num;
                result++;
                continue;
            }
            //重复项,不进行处理
            if (num == integerCurrent) {
                continue;
            }

            //能执行到这里就是值不相同的,进行数组赋值,并且改变不相同的值,还有结果长度+1
            nums[result] = num;
            integerCurrent = num;
            result++;

        }
        return result;
    }
}
