package com.huanglei.algo;


/**
 * 股票买卖
 * 每天的股票价格[6,7,3,8,11,29,7]
 * 最多买卖k次
 * 1、最多买卖1次
 * 计算以每个pos为买入点的最大profit，即与买入点后每个值相减比较得profit
 * 结果为max{profit[i]}
 * 2、最多买卖2次
 * 每个点都有两个状态持有、买入、卖出；没有卖出之前无法买入
 * dp[i][status] = max{
 *                  买： dp[i-1]-price[i]
 *                  卖： dp[i-1]+price[i]
 *                  持有：dp[i-1]
 *                  }
 *
 * 3、买卖任意次
 * 4、买卖k次
 */
public class Leetcode123_maxprofit {

    public static int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        //0 有股票
        dp[0][0] = -prices[0];
        //1 无股票
        dp[0][1] = 0;
        int max = 0;
        for(int i=1;i<prices.length;i++){
            //有股票，前一天就有，今天刚买的j
            dp[i][0] = Math.max(dp[i-1][1] - prices[i],dp[i-1][0]);
            //无股票，前一天持有or前一天买入，今天卖出
            dp[i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][1];

    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 5, 2, 4, 10};
        int k = 12;
//        System.out.println(maxProfit2(k, prices));
//        System.out.println(maxProfit(k, prices));
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int K, int[] prices) {
        if (K == 0 || prices.length == 0)
            return 0;
        int maxProfit = 0;
        if (K >= prices.length / 2) {
            for (int i = 1; i < prices.length; i++) {
                int profit = prices[i] - prices[i - 1];
                if (profit > 0) maxProfit += profit;
            }
            return maxProfit;
        }
        maxProfit = Integer.MIN_VALUE;
        int dp[][][] = new int[prices.length + 1][K + 1][2];
        //买一次算交易
        dp[0][0][0] = 0;
        for (int t = 0; t < K + 1; t++) {
            dp[0][t][1] = Integer.MIN_VALUE;
        }
        dp[0][1][0] = 0;
        for (int i = 1; i < prices.length + 1; i++) {
            for (int k = 1; k < K + 1; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][1] + prices[i - 1], dp[i - 1][k][0]);
                dp[i][k][1] = Math.max(dp[i - 1][k - 1][0] - prices[i - 1], dp[i - 1][k][1]);
                maxProfit = max(dp[i][k][0], dp[i][k][1], maxProfit);
            }
        }
        return maxProfit;
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    static int maxProfit2(int k, int[] prices) {

        if (k >= prices.length / 2) {
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                int val = prices[i] - prices[i - 1];
                sum += (val > 0 ? val : 0);
            }
            return sum;
        }

        int dp[][][] = new int[k + 1][prices.length + 1][2];
        for (int t = 0; t <= k; t++) {
            dp[t][0][1] = -1000000;
        }
        for (int i = 0; i < prices.length; i++) {
            dp[0][i][1] = -1000000;
        }

        for (int t = 1; t <= k; t++) {
            for (int i = 1; i <= prices.length; i++) {
                dp[t][i][0] = Math.max(dp[t][i - 1][0], dp[t][i - 1][1] + prices[i - 1]);
                dp[t][i][1] = Math.max(dp[t][i - 1][1], dp[t - 1][i - 1][0] - prices[i - 1]);
            }
        }
        return dp[k][prices.length][0];
    }

}
