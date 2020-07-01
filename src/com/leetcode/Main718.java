package com.leetcode;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 */
public class Main718 {
    public int findLength(int[] A, int[] B) {
        if(A.length == 0 || B.length == 0) {
            return 0;
        }
        int m = A.length + 1;
        int n = B.length + 1;
        int ans = 0;
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        Main718 m = new Main718();
        System.out.println(m.findLength(A,B));
    }

}
