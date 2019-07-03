package com.leetcodelib.p100_199;


import javax.sound.midi.Soundbank;

/**
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * -----3
 * ----/ \
 * ---9  20
 * -----/  \
 * ----15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumDepthOfBinaryTree {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        int i = maxDepth(root);
        System.out.println(i);

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 思路:
     * 递归实现.
     * 1.需要最深的,所以必定有一个左右判断的
     * 2.任意一个子节点存在,说明还需要继续往下统计
     * 3.在第二点,直到左右都不存在的时候,才说明统计结束
     * 所以此方法,是指查找当前层以及是否有下一层的总数
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if ((root.left == null && root.right == null)) {
            // 没有子节点,返回当前层的层数
            return 1;
        }

        //左子结点判断,如果有子结点的话,就递归统计
        int leftCount = 0;
        if (root.left != null) {
            leftCount = 1 + maxDepth(root.left);//本结点加上子节点的总数,递归
        }

        int rightCount = 0;
        if (root.right != null) {
            rightCount = 1 + maxDepth(root.right);
        }

        //左右,取层数最多的一边
        return Math.max(leftCount, rightCount);

    }


}
