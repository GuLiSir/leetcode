package com.leetcodelib.p00_99;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
        System.out.println(climbStairs(37));
    }


    /**
     * 说明：动态规划
     * 思路：
     * 因为每次只能走一步或者是两步，所以最后一次必定是走一步或者是两步，
     * 那么走n步所有可能的方法就是f(n)=f(n-1)+f(n-2);这里的边界情况是n=1或者是n=2的时候，分别只有一种和两种方法。
     * 可以用递归解决，但是在解答题目的时候，会报超时。
     * 经过一番查找之后，发现可以用动态规划来解决此问题，也就是从1步开始，到n步，
     * 跟前面相关的，所以可以按顺序将前面的结果用数据记录起来，再处理好边界情况即可
     */
    public static int climbStairs(int n) {

        int[] results = new int[n + 1];
        if (n == 1) return 1;
        if (n == 2) return 2;
        results[1] = 1;
        results[2] = 2;

        //f(n)=f(n-1)+f(n-2);
        for (int i = 3; i <= n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }

        return results[n];
    }


}
