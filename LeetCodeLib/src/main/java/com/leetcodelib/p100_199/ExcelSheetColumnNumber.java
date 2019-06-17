package com.leetcodelib.p100_199;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * <p>
 * 171. Excel表列序号
 * <p>
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("ZY"));
    }

    /**
     * 思路,很像十六进制,八进制的转换算法,只不过这个是改成26进制了
     */
    public static int titleToNumber(String s) {
        int length = s.length();
        int result = 0;
        int base = 1;//位数,个位十位百位,(分别对应1位,26位,26*26位)
        int mute = 'Z' - 'A' + 1;//进制数
        //从后往前遍历,
        for (int i = length; i > 0; i--) {
            char c = s.charAt(i - 1);
            int i1 = (c - 'A' + 1) * base;
            result += i1;
            base = base * mute;
        }

        return result;
    }


}
