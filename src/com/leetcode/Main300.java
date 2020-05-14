package com.leetcode;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Main300 {
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < dp.length; i++) {
            int curMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    curMax = Math.max(curMax, dp[j]);
            }
            dp[i] = curMax + 1;
            maxAns = Math.max(dp[i], maxAns);
        }
        return maxAns;
    }
}
