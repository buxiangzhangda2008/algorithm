package com.huanglei.serialization;

public class RegexImpl {

    public static void main(String[] args) {

        // System.out.println(isMatch("aab", "**c*a*b***"));
        System.out.println(isMatch("aab", "a*b*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aaa", "ab*a*c*a"));
        System.out.println(isMatch("aaa", "aa*"));
        System.out.println(isMatch("", ".*"));
        System.out.println(isMatch("", ""));
        // System.out.println(new RegexImpl().solution("aaaa", "aaaa"));
        // System.out.println(new RegexImpl().solution("aaaa", "aaa*"));
        // System.out.println(new RegexImpl().solution("abcaaa", "abca*"));
        // System.out.println(new RegexImpl().solution("a", "a*"));
        // System.out.println(new RegexImpl().solution("aaaa", "aaa*"));
    }

    // 正则表达式
    // 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
    //
    // '.' 匹配任意单个字符
    // '*' 匹配零个或多个前面的那一个元素
    // 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
    public static boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        if (p.length() > 0)
            dp[0][1] = false;
        if (s.length() > 0)
            dp[1][0] = false;
        for (int i = 2; i < p.length() + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            } else {
                dp[0][i] = false;
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {

                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2] || dp[i - 1][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public  Float methodName(){
        
        boolean dp[][] = new boolean[1][1];
        return null;
    }
}
