package com.leetcode;
/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class Main5 {
    //dp[start][end] = dp[start+1][end-1] && s.charAt(start)==s.charAt(end)
    public String longestPalindrome(String s) {
        int len = s.length();
        if (s==null || len==0)
            return s;
        boolean dp[][] = new boolean[len][len];
        String res = "";
        for (int l = 1; l <= len; l++) {
            for (int start = 0; start < len; start++) {
                int end = start + l - 1;
                if (end >= len)
                    break;
                dp[start][end] = l==1 || l==2 && s.charAt(start)==s.charAt(end) || dp[start+1][end-1] && s.charAt(start)==s.charAt(end);
                if (dp[start][end] && end-start+1 > res.length())
                    res = s.substring(start, end+1);
            }
        }
        return res;
    }
    public String youhua(String s) {    //优化后
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main5 m = new Main5();
        String s = "cbbd";
        System.out.println(m.longestPalindrome(s));
    }
}
