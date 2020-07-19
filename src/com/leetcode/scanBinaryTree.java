//二叉树的遍历
package com.leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class scanBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v) {
            val = v;
        }
    }

    private static class Pre {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        private void preOrderCur(TreeNode root) {   //先序遍历递归
            if (root == null)
                return;
            list.add(root.val);
            preOrderCur(root.left);
            preOrderCur(root.right);
        }
        private void preOrder(TreeNode root) {  //先序遍历非递归
            list.clear();
            if (root == null)
                return;
            stack.push(root);
            TreeNode p = root;
            while (!stack.empty()) {
                p = stack.pop();
                list.add(p.val);
                if (p.right != null)
                    stack.push(p.right);
                if (p.left != null)
                    stack.push(p.left);
            }
        }
    }

    private static class In {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        private void inOrderCur(TreeNode root) {    //中序遍历递归
            if (root == null)
                return;
            inOrderCur(root.left);
            list.add(root.val);
            inOrderCur(root.right);
        }
        private void inOrder(TreeNode root) {   //中序遍历非递归
            list.clear();
            TreeNode p = root;
            while (p != null || !stack.empty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
    }

    private static class Post {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        private void postOrderCur(TreeNode root) {   //后序遍历递归
            if (root == null)
                return;
            postOrderCur(root.left);
            postOrderCur(root.right);
            list.add(root.val);
        }
        private void postOrder(TreeNode root) { //后序遍历非递归
            list.clear();
            if (root == null)
                return;
            TreeNode p = root;
            TreeNode prev = root;
            while (p != null || !stack.empty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.peek().right;
                if (p==null || p == prev) {
                    p = stack.pop();
                    list.add(p.val);
                    prev = p;
                    p = null;
                }
            }
        }
    }
    public static ArrayList<Integer> cengci(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            list.add(root.val);
            if (root.left != null)
                queue.offer(root.left);
            if (root.right != null)
                queue.offer(root.right);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        root.left = b;
        root.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        f.left = g;
        Pre pre = new Pre();
        pre.preOrderCur(root);
        System.out.println("先序遍历递归：" + pre.list);
        pre.preOrder(root);
        System.out.println("先序遍历非递归：" + pre.list);
        In in = new In();
        in.inOrderCur(root);
        System.out.println("中序遍历递归：" + in.list);
        in.inOrder(root);
        System.out.println("中序遍历非递归：" + in.list);
        Post post = new Post();
        post.postOrderCur(root);
        System.out.println("后序遍历递归：" + post.list);
        post.postOrder(root);
        System.out.println("后序遍历非递归：" + post.list);
        System.out.println("层次遍历：" + cengci(root));
    }
}