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
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            //被查找的字符串长度比要查找的字符串还短,绝对找不到的
            return -1;
        }

        //当匹配到第一个字符的时候,匹配到第一个字符的索引,如果当前没有匹配到,则值为-1
        int findStartIndex = -1;

        //从需要查找的字符串开始找
//        for (int i = 0; i < needle.length(); i++) {
        for (int i1 = 0; i1 < haystack.length() ; i1++) {
            if (haystack.charAt(i1) == needle.charAt(0) && findStartIndex == -1) {
                //设置索引位置
                findStartIndex = i1;
                continue;
            }
            //判断当前第一个字符串是否匹配到了
            if (findStartIndex != -1) {
                //匹配到了
                if (needle.charAt(i1 - findStartIndex-1) == haystack.charAt(i1)) {
                    //全部匹配完成了
                    if (i1 - findStartIndex == needle.length()) {
                        return findStartIndex;
                    }
                } else {
                    //该次匹配失败,重新进行匹配
                    findStartIndex = -1;
                }
            }

        }
        if (findStartIndex == -1) {
            //对被查找的字符串一个字符都没有找到,则代表匹配不到,返回-1
            return -1;
        }

//        }
        throw new IllegalStateException();
//        return -1;
    }
}
