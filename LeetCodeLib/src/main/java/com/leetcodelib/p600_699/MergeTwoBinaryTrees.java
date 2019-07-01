package com.leetcodelib.p600_699;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * <p>
 * <p>
 * 617. 合并二叉树
 * <p>
 * <p>
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 */
public class MergeTwoBinaryTrees {


    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(3);
        tree1.right = new TreeNode(2);
        tree1.right.left = new TreeNode(5);

        TreeNode tree2 = new TreeNode(2);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.right.left = new TreeNode(7);

        TreeNode treeNode = mergeTrees(tree1, tree2);
        List<Integer> integers = new ArrayList<>();
        integers.add(treeNode.val);

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
     * 合并二叉树的话,依据题意,肯定需要遍历两颗树了,可以使用循环和递归,这里考虑的是递归.
     * 以某一树中任意某一结点来考虑的话,需要做的工作就是合并另一棵树同等位置的结点,然后检查是否需要继续
     * 往下合并(左和右).需要往下合并的话,取出子节点,继续重复上一行思路.
     * 由此,可以将其单独抽成一个递归的方法,由最顶层开始传入.
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode treeNodeResult = new TreeNode(0);
        MergeChildTree(treeNodeResult, t1, t2);
        return treeNodeResult;

    }

    /**
     * 合并当前子节点,并且会检查该子节点是否有需要合并的子节点
     */
    public static void MergeChildTree(TreeNode p, TreeNode t1, TreeNode t2) {

        //合并当前节点
        p.val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);

        if ((t1 != null && t1.left != null)
                || (t2 != null && t2.left != null)) {
            //有左子节点,继续合并左边的子节点
            p.left = new TreeNode(0);
            MergeChildTree(p.left, t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        }
        if ((t1 != null && t1.right != null)
                || (t2 != null && t2.right != null)) {
            //有右子节点,继续合并右边的子节点
            p.right = new TreeNode(0);
            MergeChildTree(p.right, t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        }

    }


}
