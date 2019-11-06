package com.leetcodelib.p200_299;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 226. 翻转二叉树
 * <p>
 * <p>
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * <p>
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode input = new TreeNode(4);
        input.left = new TreeNode(2);
        input.right = new TreeNode(7);
        input.left.left = new TreeNode(1);
        input.left.right = new TreeNode(3);
        input.right.left = new TreeNode(6);
        input.right.right = new TreeNode(9);

        PrintFromTopToBottom(input);
        TreeNode output = invertTree(input);

        PrintFromTopToBottom(output);

    }


    /**
     * 递归实现,优先判断左结点是否有需要翻转的  有的话就往下翻转.
     * 思路有点类似于遍历二叉树,只不过后面加个翻转操作
     */
    public static TreeNode invertTree(TreeNode root) {
        invertTree111(root);

        return root;
    }

    public static void invertTree111(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            invertTree111(root.left);
        }
        if (root.right != null) {
            invertTree111(root.right);
        }

        //交换左右结点
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

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
     * 打印二叉树,与解题无关
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        // 异常条件判断
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode left = current.left;
            TreeNode right = current.right;
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
            result.add(current.val);
        }


        StringBuilder s = new StringBuilder();
        for (Integer integer : result) {
            s.append(integer).append(" ");
        }
        System.out.println(s);

        return result;
    }


}
