package com.huanglei.serialization;

public class MaxProfits {

    public static void main(String[] args) {
        System.out.println("MaxProfits");
        // int[] prices = new int[] {7,1,5,3,6,4};
        int[] prices = new int[] {7,6,4,3,1};
        new MaxProfits().maxProfits(prices);
    }

    public static void maxProfits(int prices[]) {
        int dp[][] = new int[prices.length][2];
        // init
        dp[0][0] = -prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            maxProfit = Math.max(dp[i][1], maxProfit);
        }
        System.out.println("max profits is:" + maxProfit);
    }

}
