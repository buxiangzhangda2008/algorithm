package com.huanglei.serialization;

public class LonggestIncresingSeq2 {

    public static void main(String[] args) {
        // int numbers[] = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        int numbers[] = new int[] { 0, 1, 0, 3, 2, 3 };
        // int numbers[] = new int[] { 7, 7, 7, 7, 7, 7, 7 };
        int maxLen = new LonggestIncresingSeq2().solution(numbers);
        System.out.println("maxLen:" + maxLen);
    }

    private int getMaxLenFromPos(int i, int[] numbers) {

        int maxLen = 1;
        for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[j] > numbers[i]) {
                int tmplen = 1 + getMaxLenFromPos(j, numbers);
                maxLen = Math.max(tmplen, maxLen);
            }
        }

        return maxLen;
    }

    public int solution(int[] numbers) {

        int maxLen = 1;
        int[] dp = new int[numbers.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        return maxLen;
    }
}
