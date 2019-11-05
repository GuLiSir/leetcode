package com.leetcodelib.p1200_1299;

/**
 * 1221. 分割平衡字符串
 * <p>
 * <p>
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的最大数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 2：
 * <p>
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 3：
 * <p>
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SplitAStringInBalancedStrings {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }

    /**
     * 思路:
     * 要分割的尽量多,也就是每一组的LR出现的次数越少越好.所以按顺序遍历的时候,每组成一组LR就分割一次
     */
    public static int balancedStringSplit(String s) {
        int lc = 0;//'L'的计数
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char i1 = s.charAt(i);
            if (i1 == 'L') {
                lc++;
            } else if (i1 == 'R') {
                lc--;
            }

            if (lc==0) {
                result++;
            }

        }
        return result;
    }
}
