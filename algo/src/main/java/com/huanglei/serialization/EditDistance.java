package com.huanglei.serialization;

public class EditDistance {

    public static void main (String[] args) {
        System.out.println("EditDistance");
        new EditDistance().solution("horse", "ros");
        new EditDistance().solution("hello", "helo");
        new EditDistance().solution("intention", "execution");
        
//        System.out.println(editDistance("intention", "execution"));
    }

    /**
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符
示例 1：
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2：
输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
     */
    public void solution(String word1,String word2) {
        int[][] dp  = new int[word1.length()+1][word2.length()+1];
        //init
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = i;
        }
        for(int i = 0;i<dp[0].length;i++){
            dp[0][i] = i;
        }

        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[i].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i][j-1]);
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j]) + 1;
                }
            }
        }
        System.out.println("distance is:"+dp[word1.length()][word2.length()]);
    }

}
