package com.leetcodelib;

import java.io.File;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.exit(5);
        System.out.println(longestCommonPrefix("flower", "flow", "flight"));
        System.out.println(longestCommonPrefix("flower", "flow", "floght"));
        System.out.println(longestCommonPrefix("asdfghjk", "asdfyui", "asdfeqwr"));
    }


    public static String longestCommonPrefix(String... strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int lengthHead = Integer.MAX_VALUE;
        //前缀最大长度也就取决于最短的那个单词
        for (String str : strs) {
            lengthHead = Math.min(lengthHead, str.length());
        }
        StringBuilder builder = new StringBuilder();

        //第一个单词
        String strFirst = strs[0];

        for (int i = 0; i < lengthHead; i++) {
            for (int i1 = 1; i1 < strs.length; i1++) {
                //当前要对比的单词
                String str = strs[i1];
                if (strFirst.charAt(i) != str.charAt(i)) {
                    //这里匹配不上了,说明查找结束,返回结果
                    return builder.toString();
                }
            }
            builder.append(strFirst.charAt(i));
        }

        return builder.toString();
    }
}
