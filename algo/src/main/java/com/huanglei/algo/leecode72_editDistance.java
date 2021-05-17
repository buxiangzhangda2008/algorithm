package com.huanglei.algo;

/**
 * word1->word2 最少需要的步骤
 * 可以 insert 、delete、replace单个字符
 */
public class leecode72_editDistance {


    public static void main(String[] args) {
        System.out.println(editDistance("intention","execution"));
        System.out.println(editDistance("hrose", ""));
    }

    public static int editDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //dp[i][j]表示word1的前i个字符转换为word2的前j个字符最少需要的步骤；
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = j;
        }
        //aaaa
        //aabc
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
