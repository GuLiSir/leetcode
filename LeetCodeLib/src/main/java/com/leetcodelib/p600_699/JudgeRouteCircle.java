package com.leetcodelib;

/**
 * https://leetcode-cn.com/problems/judge-route-circle/description/
 * 657. 判断路线成圈
 * 初始位置 (0, 0) 处有一个机器人。给出它的一系列动作，判断这个机器人的移动路线是否形成一个圆圈，换言之就是判断它是否会移回到原来的位置。
 * <p>
 * 移动顺序由一个字符串表示。每一个动作都是由一个字符来表示的。机器人有效的动作有 R（右），L（左），U（上）和 D（下）。输出应为 true 或 false，表示机器人移动路线是否成圈。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "UD"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "LL"
 * 输出: false
 */
public class JudgeRouteCircle {

    public static void main(String[] args) {

        System.out.println(judgeCircle("LRLLUDD"));
    }

    /**
     * 基本思想:用个计数器来统计走的方向,例如向左就+1,向右就-1,
     * 只要两个计数同时为0的话,就回到原点了
     */
    public static boolean judgeCircle(String moves) {
        //v为垂直方向上的计数器,h为水平方向上的计数器
        int v = 0, h = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            String s = String.valueOf(c);
            switch (s) {
                case "U":
                    v++;
                    break;
                case "D":
                    v--;
                    break;
                case "L":
                    h--;
                    break;
                case "R":
                    h++;
                    break;
            }
        }
        return v == 0 && h == 0;
    }
}
