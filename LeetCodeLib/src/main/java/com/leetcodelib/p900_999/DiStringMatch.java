package com.leetcodelib.p900_999;

import java.util.Arrays;

/**
 * 942. 增减字符串匹配
 * di-string-match
 * <p>
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * <p>
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * <p>
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 * <p>
 * 输出："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 * <p>
 * 输出："DDI"
 * 输出：[3,2,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 1000
 * S 只包含字符 "I" 或 "D"。
 */
public class DiStringMatch {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));//[0,4,1,3,2]
        System.out.println(Arrays.toString(diStringMatch("III")));//[0,1,2,3]
        System.out.println(Arrays.toString(diStringMatch("DDI")));//[3,2,0,1]
    }

    /**
     * 思路,根据题目意思可以得出,有n位数的字符串,得出结果长度为n+1,并且数值是0-n,不重复;
     * 可以使用两个变量来记录边界,遇到'i'则使用最小的变量,这样能保证后续遇到'i',还能继续增大;
     * 'd'的相反
     */
    public static int[] diStringMatch(String S) {
        int length = S.length();
        int[] result = new int[length + 1];
        int min = 0;
        int max = length;

        for (int i = 0; i < length; i++) {
            char charAt = S.charAt(i);
            if (charAt == 'I') {
                //增大
                result[i] = min;
                min++;
            } else if (charAt == 'D') {
                //减小
                result[i] = max;
                max--;
            } else {
                throw new IllegalStateException();
            }
        }

        result[length] = max;//最后一位为最大值或者是最小值,他们都一样
        //或者是result[result.length-1] = min;  都可以

        return result;
    }

}
