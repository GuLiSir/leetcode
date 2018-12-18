package com.leetcodelib.p300_399;

/**
 * 344. 反转字符串
 * <p>
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 */
public class ReverseString {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        String outPut = reverseString(input);
        System.out.println(outPut);
    }

    public static String reverseString(String s) {
        StringBuilder builder = new StringBuilder();
        for (int length = s.length(); length > 0; length--) {
            builder.append(s.charAt(length - 1));
        }
        return builder.toString();
    }
}
