package com.leetcode;

public class Main108 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return recur(nums, 0, nums.length-1);
    }
    public TreeNode recur(int[] nums, int l, int r) {
         if (l == r) {
             return new TreeNode(nums[l]);
         } else if (l > r) {
             return null;
         }
         int mid = (l + r) / 2;
         TreeNode root = new TreeNode(nums[mid]);
         root.left = recur(nums, l, mid - 1);
         root.right = recur(nums, mid + 1, r);
         return root;
    }
}
