package com.leetcodelib.p100_199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 * 102. 二叉树的层次遍历
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * /   \
 * 9   20
 * ---/  \
 * --15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(9);
        treeNode1.right = new TreeNode(20);
        treeNode1.right.left = new TreeNode(15);
        treeNode1.right.right = new TreeNode(7);

        List<List<Integer>> lists = levelOrder(treeNode1);
        StringBuilder builder = new StringBuilder();
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                builder.append(integer).append(",");
            }
        }
        System.out.println(builder.toString());
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
     * 传入的参数进行判断,空的情况直接返回空数据.
     * 分层遍历,则需要用一个list将同一层的数据存储起来,然后得到结果.
     * 遍历完这一层,还需要有下一层的数据,所以就在上一个步骤,顺便将下一层数据找出来
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();//结果

        List<TreeNode> treeNodeList = new ArrayList<>();//当前层的结点列表
        List<TreeNode> treeNodeListNext = new ArrayList<>();//下一层的结点列表

        //前面进行了空判断,所以这里必定有一个结点,为初始的第一个
        treeNodeList.add(root);
        result.add(new ArrayList<Integer>());
        result.get(0).add(root.val);


        //判断当前层,是否有结点数据,如果有的话,就一直遍历下去
        while (!treeNodeList.isEmpty()) {
            List<Integer> integerList = new ArrayList<>();
            //遍历当前层的数据
            for (TreeNode treeNode : treeNodeList) {
                //左右结点是否有数据判断
                if (treeNode.left != null) {
                    integerList.add(treeNode.left.val);
                    treeNodeListNext.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    integerList.add(treeNode.right.val);
                    treeNodeListNext.add(treeNode.right);
                }

            }
            if (!integerList.isEmpty()) {
                //当前层有数据,添加到结果
                result.add(integerList);
            }

            //下一层数据作为本层数据,进入下一个循环
            treeNodeList.clear();
            treeNodeList.addAll(treeNodeListNext);
            treeNodeListNext.clear();
        }

        return result;
    }


}
