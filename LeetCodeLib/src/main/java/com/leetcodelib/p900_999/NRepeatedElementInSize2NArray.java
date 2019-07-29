package com.leetcodelib.p900_999;

/**
 * 961. 重复 N 次的元素
 * <p>
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * <p>
 * 返回重复了 N 次的那个元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NRepeatedElementInSize2NArray {
    public static void main(String[] args) {
        int[] a = new int[]{5,1,5,2,5,3,5,4};
        System.out.println(repeatedNTimes(a));
    }

    /**
     * 思路:
     * 因为是有N+1个不同元素,那么除了重复的那个元素之外,其余的元素都是不重复的.
     * 所以知道找到重复次数大于等于2次的就行了
     *
     * 第一遍遍历,然后在遍历的内部,再跟后面的元素进行判断,如果有相等的值,就是该值重复了
     * 从第i个位置,然后跟i+1直到2N,进行对比,如果有重复,则返回结果
     */
    public static int repeatedNTimes(int[] A) {
        int length = A.length;
        for (int i = 0; i < length - 1; i++) {
            for (int i1 = i + 1; i1 < length; i1++) {
                if (A[i]==A[i1]){
                    return A[i];
                }
            }
        }
        throw new RuntimeException();
    }


}
