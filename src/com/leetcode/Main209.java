package com.leetcode;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 */
public class Main209 {
    public int minSubArrayLen(int s, int[] nums) {
        int len = Integer.MAX_VALUE;
        if (nums==null || nums.length==0)
            return 0;
        int left = 0;
        int right = left;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                len = Math.min(len, right-left);
                sum -= nums[left++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
    public static void main(String[] args) {
        Main209 m = new Main209();
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(m.minSubArrayLen(s, nums));
    }
}
