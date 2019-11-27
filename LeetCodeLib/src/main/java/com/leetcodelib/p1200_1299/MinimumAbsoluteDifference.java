package com.leetcodelib.p1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1200. 最小绝对差
 * <p>
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumAbsoluteDifference {

    public static void main(String[] args) {

//        List<List<Integer>> lists = minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27});
        List<List<Integer>> lists = minimumAbsDifference(new int[]{40, 11, 26, 27, -20});

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + ",");

            }
            System.out.print("  ");
        }

    }


    /**
     * 说明:
     * 先排序,排序之后最小差肯定是取决于各个元素的左右邻的差值.
     * 刚开始先取得第0,1的差值,之后每往后移一位,再往后两两得出差值,与之前的相比看绝对差是否变小
     */
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        int absV = Math.abs(arr[0] - arr[1]);//取得默认的绝对差
        List<Integer> integers = new ArrayList<>();
        integers.add(arr[0]);
        integers.add(arr[1]);
        result.add(integers);

        for (int i = 1; i < arr.length - 1; i++) {
            int i1 = arr[i] - arr[i + 1];
            int abs = Math.abs(i1);
            if (abs < absV) {
                result.clear();
                List<Integer> integers1 = new ArrayList<>();
                integers1.add(arr[i]);
                integers1.add(arr[i + 1]);
                result.add(integers1);
                absV = abs;//更新最小绝对差
            } else if (abs == absV) {
                List<Integer> integers1 = new ArrayList<>();
                integers1.add(arr[i]);
                integers1.add(arr[i + 1]);
                result.add(integers1);
            }
        }

        return result;
    }


}
