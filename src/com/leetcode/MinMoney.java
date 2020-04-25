package com.leetcode;

public class MinMoney {
    public static int minConins1(int[] arr, int aim){
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
        for(int i=0; i < arr.length; i++){
            for(int j=0; j<= aim; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[arr.length-1][aim] != max ? dp[arr.length-1][aim] : -1;
    }
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        int aim = 5;
        System.out.println(minConins1(arr, aim));
    }
}
