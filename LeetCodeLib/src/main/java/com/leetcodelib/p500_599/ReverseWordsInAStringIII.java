package com.leetcodelib.p500_599;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * <p>
 * 557. 反转字符串中的单词 III
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWordsInAStringIII {

    public static void main(String[] args) {
        System.out.println("s'teL ekat edoCteeL tsetnoc".equals(reverseWords("Let's take LeetCode contest")));
    }


    /**
     * 思路:依照题意直接按照空格分开字符串,然后翻转
     */
    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder builder = new StringBuilder();
        int length1 = s1.length;
        for (int i = 0; i < length1; i++) {
            String s2 = s1[i];
            for (int length = s2.length(); length > 0; length--) {
                char c = s2.charAt(length - 1);
                builder.append(c);
            }
            //过滤掉最后一个空格
            if (i != length1 - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

}
