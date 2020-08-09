package com.leetcode;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
public class Main122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                res += prices[i] - prices[i-1];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] num = {7,1,5,3,6,4};
        Main122 m = new Main122();
        System.out.println(m.maxProfit(num));
    }
}
