package com.leetcode;

public class Pack {
    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2};
        int[] v = {12, 10, 20, 15};
        int[] m = {2, 3, 3, 6};
        Pack01 pack01 = new Pack01();
        System.out.println(pack01.knapSack(w, v, 5));
        System.out.println(pack01.youhua(w, v, 5));
        Packwq packwq = new Packwq();
        System.out.println(packwq.wqpack(w, v, 5));
        System.out.println(packwq.youhua(w, v, 5));
        Packdc packdc = new Packdc();
        System.out.println(packdc.dcpack(w, v, m, 5));
        System.out.println(packdc.youhua(w, v, m, 5));
    }
}

class Pack01 {
    public int knapSack(int[] w, int[] v, int cap) { //未优化
        int num = w.length;
        if (num == 0 || cap == 0)
            return 0;
        int[][] dp = new int[num][cap+1];
        for (int i = 0; i <= cap; i++) {
            dp[0][i] = w[0]<=i ? v[0] : 0;  //先初始化放入第一个物品
        }
        for (int i = 1; i < num; i++) {
            for (int j = 0; j <=cap ; j++) {
                dp[i][j] = dp[i-1][j];  //默认为不放当前第i个物品
                if (w[i] <= j)
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i-1][j-w[i]]);
            }
        }
        return dp[num-1][cap];
    }
    public int youhua(int[] w, int[] v, int cap) {  //优化后
        int num = w.length;
        int[] dp = new int[cap+1];
        for (int i = 0; i < num; i++) {
            for (int j = cap; j >= w[i]; j--) {    //从最后一个背包开始装
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
            }
        }
        return dp[cap];
    }
}

class Packwq {
    public int wqpack(int[] w, int[] v, int cap) {
        //dp[i][j] = max{dp[i-1][t - w[i] * k] + v[i] * k}; （0 <= k * w[i] <= j）
        int[][] dp = new int[v.length+1][cap+1];
        for(int i = 0; i < v.length; i++) {
            for(int j = 0; j <= cap; j++) {
                for(int k=0; k * w[i] <= j; k++)
                    dp[i+1][j]=Math.max(dp[i+1][j], dp[i][j - k * w[i]] + k * v[i]);
            }
        }
        return dp[v.length][cap];
    }
    public int youhua(int[] w, int[] v, int cap) {  //优化后的算法
        //dp[j] = max(dp[j], dp[j-w[i]]+v[i])
        int[] dp = new int[cap+1];
        for (int i = 0; i < v.length; i++) {
            for (int j = w[i]; j <= cap; j++) {    //从第一个可装的背包开始装
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
            }
        }
        return dp[cap];
    }
}

class Packdc {
    public int dcpack(int[] w, int[] v, int[] m, int cap) {
        int[][] dp = new int[v.length+1][cap+1];
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j <= cap; j++) {
                for (int k = 0; k<=m[i] && k*w[i]<=j ; k++) {
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j - k * w[i]] + k * v[i]);
                }
            }
        }
        return dp[v.length][cap];
    }
    public int youhua(int[] w, int[] v, int[] m, int cap) {
        int[] dp = new int[cap+1];
        for (int i = 0; i < v.length; i++) {
            int k = 1;
            for (int j = w[i]; k<=m[i] && j<=cap ; j++) {
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
                k++;
            }
        }
        return dp[cap];
    }
}
