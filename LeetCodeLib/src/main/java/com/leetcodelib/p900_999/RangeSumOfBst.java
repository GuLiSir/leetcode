package com.leetcodelib.p900_999;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * <p>
 * 938. 二叉搜索树的范围和
 * <p>
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 */
public class RangeSumOfBst {


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        treeNode1.left = new TreeNode(5);
        treeNode1.right = new TreeNode(15);
        treeNode1.left.left = new TreeNode(3);
        treeNode1.left.right = new TreeNode(7);
        treeNode1.right.left = null;
        treeNode1.right.right = new TreeNode(18);
        int i = rangeSumBST(treeNode1, 7, 15);
        System.out.println(i);
    }

    /**
     * 普通的遍历二叉树的方法，然后再额外加多一个范围判断
     */
    public static int rangeSumBST(TreeNode root, int L, int R) {
        int result = 0;

        if (root.left!=null) {
            result+= rangeSumBST(root.left, L, R);
        }
        if (root.right!=null) {
            result+= rangeSumBST(root.right, L, R);
        }
        if (L-1<root.val&&root.val<R+1) {
            result+=root.val;
        }

        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
