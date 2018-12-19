package com.leetcodelib.p200_299;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] ints = new int[]{0, 1, 0, 3, 12};
        moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 分析:
     *  从头开始遍历数组,然后判断是否为0,如果是0的话,就讲后面部位0的数值移至该位置,然后移过来的位置设置为0,
     *  相当于直接调换位置,这样,直到最后都遍历完成了,说明移动0也就完成了
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                //后一位开始找,如果找到非0的,将其移至0处,然后将移过来的位置设置为0(相当于调换位置)
                for (int i1 = i + 1; i1 < nums.length; i1++) {
                    if (nums[i1] != 0) {
                        nums[i] = nums[i1];
                        nums[i1] = 0;
                        break;
                    }
                }
            }
        }
    }

}
