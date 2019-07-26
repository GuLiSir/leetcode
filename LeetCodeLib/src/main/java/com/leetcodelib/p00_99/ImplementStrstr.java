package com.leetcodelib;

/**
 * https://leetcode-cn.com/problems/implement-strstr/description/
 * 28. 实现strStr()
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class ImplementStrstr {

    public static void main(String[] args) {
        //2
        System.out.println(strStr("hello", "ll"));
        //0
        System.out.println(strStr("0123456789", "0"));
        //4
        System.out.println(strStr("0123456789", "456"));
        //9
        System.out.println(strStr("0123456789", "9"));
        //-1
        System.out.println(strStr("0123456789", "abc"));
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("aaa", "aaa"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length()==0) {
            //当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
            return 0;
        }
        int length = haystack.length();
        int needleLength = needle.length();
        if (needleLength > length) {
            //查找的字符,比被查找的长,肯定找不到
            return -1;
        }

        char charAtNeedleFirst = needle.charAt(0);
        for (int i = 0; i < length; i++) {
            char c = haystack.charAt(i);
            if (c == charAtNeedleFirst) {
                if (needleLength==1){
                    //要查找的只有一位,直接返回匹配结果
                    return i;
                }
                if (i + needleLength > length) {
                    //被查找的字符串,剩余长度不够了
                    return -1;
                }
                for (int i1 = 1; i1 < needleLength; i1++) {
                    if (haystack.charAt(i + i1) == needle.charAt(i1)) {
                        if (i1 == needleLength - 1) {
                            //全部匹配完成,符合查找要求
                            return i;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;
    }


}
