package com.leetcodelib;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        for (List<Integer> integers : generate) {
            for (Integer integer : integers) {
                System.out.println(integer + ",");
            }
            System.out.println("\n");

        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> integerList = new ArrayList<>();
            //每一行添加一个
            result.add(integerList);
            for (int i1 = 0; i1 <= i; i1++) {
                if (i1 == 0 || i1 == i
                        ) {
                    //最前和最后都是为1
                    integerList.add(1);
                    continue;
                }
                //获取上一行的数据
                List<Integer> integers = result.get(i-1 );
                integerList.add( integers.get( i1-1 )+ integers.get( i1) );
            }
        }
        return result;
    }
}
