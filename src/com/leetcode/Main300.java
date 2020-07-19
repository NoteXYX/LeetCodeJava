package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Main300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        List<Integer> list = new ArrayList<>();
        int pos = 0;
        int posDp = 0;
        int maxAns = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] >= maxAns)
                        pos = i;
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        posDp = maxAns;
        list.add(nums[pos]);
        for (int i = pos-1; i >= 0 ; i--) {
            if (dp[i] == posDp-1) {
                list.add(0, nums[i]);
                posDp -= 1;
            }
        }
        System.out.println(list);
        return maxAns;
    }

    public static void main(String[] args) {
        Main300 m = new Main300();
        int[] nums = {10,9,2,5,3,7,18,118,1};
        System.out.println(m.lengthOfLIS(nums));
    }
}
