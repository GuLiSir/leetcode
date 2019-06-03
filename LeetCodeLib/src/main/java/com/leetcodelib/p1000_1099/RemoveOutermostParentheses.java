package com.leetcodelib.p1000_1099;

/**
 * 1021. 删除最外层的括号
 * <p>
 * <p>
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * <p>
 * 提示：
 * <p>
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 */
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = removeOuterParentheses("(()())(())");
        System.out.println("()()()".equals(s));

        String s1 = removeOuterParentheses("(()())(())(()(()))");
        System.out.println("()()()()(())".equals(s1));

        String s2 = removeOuterParentheses("()()");
        System.out.println("".equals(s2));

    }


    /**
     * 思路:括号都是成双成对出现的,也就是说,左括号的数量等于右括号的数量,所以如果遍历的时候,遇到左括号加1,
     * 右括号减一,那么最终会得到0;但是在途中得到0的时候,说明刚好有一组括号闭合了(一个原语)
     */
    public static String removeOuterParentheses(String s) {
        int leftCount = 0;//做括号计数
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                leftCount++;
                if (leftCount > 1) {
                    builder.append(c);
                }
            } else if (')' == c) {
                leftCount--;
                if (leftCount > 0) {
                    builder.append(c);
                }
            }
        }
        return builder.toString();
    }

}
