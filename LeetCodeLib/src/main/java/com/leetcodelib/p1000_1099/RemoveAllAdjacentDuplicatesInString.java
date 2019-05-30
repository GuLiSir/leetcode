package com.leetcodelib.p1000_1099;


/**
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * 1047. 删除字符串中的所有相邻重复项
 * <p>
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("aaca"));
        System.out.println(removeDuplicates("aaaaaaaa"));
    }

    public static String removeDuplicates(String S) {

        StringBuilder builder = new StringBuilder(S);
        char index = '.';//点号表示默认值
        for (int i = 0; i < builder.length(); i++) {
            char charAt = builder.charAt(i);
            if (index == '.') {
                index = charAt;
                continue;
            }
            if (charAt == index) {
                //重复了,删除本字符还有上一个字符
                builder.deleteCharAt(i);
                builder.deleteCharAt(i - 1);
                //重置状态,并且使其重新遍历
                index = '.';
                i = -1;//因为循环中i++的存在,设置为-1,然后i++会变为0,使其重新开始遍历
            } else {
                //不重复,更新索引的字符
                index = charAt;
            }
        }
        return builder.toString();
    }

}
