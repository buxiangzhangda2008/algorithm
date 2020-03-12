package com.huanglei.algo;


/**
 * 零钱兑换
 * 【1，2，5】最少需要多少枚硬币面值可以累加成N
 */
public class leecode322_coinChange {


    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2, 5, 10, 1}, 27));
    }

    public static int coinChange(int coins[], int amount) {

        int[] dp = new int[amount + 1];
        //dp[i]表示凑成i需要的最少硬币数量；
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE)
                    min = Math.min(dp[i - coins[j]], min);
            }
            dp[i] = min == Integer.MAX_VALUE ? min : min + 1;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
