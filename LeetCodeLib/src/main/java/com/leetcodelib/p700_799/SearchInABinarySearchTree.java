package com.leetcodelib.p700_799;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * <p>
 * <p>
 * 700. 二叉搜索树中的搜索
 * <p>
 * <p>
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * <p>
 * 例如，
 * <p>
 * 给定二叉搜索树:
 * <p>
 * ----4
 * ---/ \
 * --2   7
 * -/ \
 * 1   3
 * <p>
 * 和值: 2
 * 你应该返回如下子树:
 * -2
 * / \
 * 1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInABinarySearchTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);


        TreeNode treeNode = searchBST(root, 2);//断点获取结果

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
     * 遍历二叉树的同时,顺便判断结果,结果对的上,就返回结果.
     * 这里使用的是递归遍历树.
     */
    public static TreeNode searchBST(TreeNode root, int val) {

        if (root.val == val) {
            //结果匹配,返回结果
            return root;
        } else {
            //判断是否有左子树
            if (root.left != null) {
                TreeNode treeNode = searchBST(root.left, val);
                if (treeNode != null) {
                    //有搜索到结果,返回结果
                    return treeNode;
                }
            }
            //判断是否有右子树
            if (root.right != null) {
                TreeNode treeNode = searchBST(root.right, val);
                if (treeNode != null) {
                    //有搜索到结果,返回结果
                    return treeNode;
                }
            }
        }
        //没有找到结果
        return null;
    }


}
