package com.leetcodelib;

import java.util.ArrayList;

/**
 * 500. 键盘行
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 * <p>
 * 示例1:
 * <p>
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * 注意:
 * <p>
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 */
public class KeyboardRow {
    public static void main(String[] args) {
        String[] words = findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static String[] findWords(String[] words) {

        ArrayList<String> arrayList = new ArrayList<>();

        //遍历每一个单词
        for (String word : words) {
            //每个单词的每个字母
            boolean word1 = findWord(word.toLowerCase());
            if (word1) {
                arrayList.add(word);
            }
        }
        String[] result = new String[arrayList.size()];
        return arrayList.toArray(result);

    }

    private static final String line1 = "qwertyuiop";
    private static final String line2 = "asdfghjkl";
    private static final String line3 = "zxcvbnm";
    private static final String[] keyBoard = new String[]{line1, line2, line3};

    private static boolean findWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (String s : keyBoard) {
                String lineTag = null;
                //键盘的每一行
                for (int i1 = 0; i1 < s.length(); i1++) {
                    //键盘的每个按键
                    char c1 = s.charAt(i1);
                    if (c == c1) {
                        lineTag = s;
                        break;
                    }
                }
                //说明找到键盘对应的行
                if (lineTag != null) {
                    for (int i1 = 0; i1 < word.length(); i1++) {
                        char c1 = word.charAt(i1);
                        boolean find = false;
                        for (int i2 = 0; i2 < lineTag.length(); i2++) {
                            if (lineTag.charAt(i2) == c1) {
                                find = true;
                                break;
                            }
                        }
                        if (!find) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }


}
