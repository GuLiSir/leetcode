package com.leetcodelib.p500_599;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * <p>
 * <p>
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class NAryTreePostorderTraversal {

    public static void main(String[] args) {
        Node node = new Node(1);
        List<Node> children1 = new ArrayList<>();
        children1.add(new Node(3));
        children1.add(new Node(2));
        children1.add(new Node(4));
        node.children = children1;

        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5));
        children2.add(new Node(6));
        node.children.get(0).children = children2;
        List<Integer> postorder = postorder(node);
        for (Integer integer : postorder) {
            System.out.println(integer + " ");
        }
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        if (root.children == null || root.children.isEmpty()) {
            //没有子节点了，返回当前节点
            result.add(root.val);
            return result;
        } else {
            //还有子节点，继续往下遍历
            for (Node child : root.children) {
                List<Integer> postorder = postorder(child);
                result.addAll(postorder);
            }
            result.add(root.val);//添加自身
        }

        return result;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


}
