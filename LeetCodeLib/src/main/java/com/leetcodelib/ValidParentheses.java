package com.leetcodelib;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));

    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            //长度为奇数肯定是无效的
            return false;
        }
        //存放符号的数组
        char[] chars = new char[s.length()];

        //最后一个存放位置的索引
        int indexKey = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //左括号有效
            if (c == '{'
                    || c == '('
                    || c == '['
                    ) {
                chars[indexKey] = c;
                indexKey++;
                continue;
            }
            if (indexKey==0) {
                return false;
            }
            //判断有括号是否有效,indexKey-1是因为上面的一个条件会+1
            if (c == '}' && chars[indexKey-1] == '{'
                    || c == ')' && chars[indexKey-1] == '('
                    || c == ']' && chars[indexKey-1] == '['
                    ) {

                indexKey--;
                continue;
            }
            return false;
        }

        if (indexKey!=0) {
            //执行到这里说明有配对不上的左括号
            return false;
        }
        return true;
    }

}
