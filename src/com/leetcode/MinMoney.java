package com.leetcode;

public class MinMoney {
    public int minConins1(int[] arr, int aim){  //未优化
        if(arr == null || arr.length == 0 || aim < 0){
            return -1;
        }
        int[][] dp = new int[arr.length][aim+1];
        int max = Integer.MAX_VALUE;
        //设置第一行
        for(int j=1; j <= aim; j++){
            dp[0][j] = max;
            if (j % arr[0] == 0) {
                dp[0][j] = j / arr[0];
            }
//            if(j-arr[0] >= 0 && dp[0][j-arr[0]] != max ){
//                dp[0][j] = dp[0][j-arr[0]] + 1;
//            }
        }
        int left = 0;
        for(int i=1; i < arr.length; i++){
            for(int j=1; j <=aim; j++){
                left = max;
                if(j-arr[i] >=0 && dp[i][j-arr[i]] != max){
                    left = dp[i][j-arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i-1][j]);
            }
        }
        return dp[arr.length-1][aim] != max ? dp[arr.length-1][aim] : -1;
    }
    public int youhua(int[] arr, int aim) { //优化后
        if (arr == null || arr.length == 0)
            return -1;
        int[] dp = new int[aim+1];
        int max = Integer.MAX_VALUE;
        //先放第一行
        for (int i = 1; i <= aim; i++) {
            dp[i] = max;
            if (i % arr[0] == 0)
                dp[i] = i / arr[0];
        }
        int tmp = max;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                tmp = max;
                if (j - arr[i] >= 0 && dp[j-arr[i]] != max)
                    tmp = dp[j-arr[i]] + 1;
                dp[j] = Math.min(dp[j], tmp);
            }
        }
        for(int i=0; i<= aim; i++){
            System.out.println(dp[i]);
        }
        return dp[aim];
    }
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        int aim = 5;
        MinMoney m = new MinMoney();
        System.out.println(m.youhua(arr, aim));
    }
}
