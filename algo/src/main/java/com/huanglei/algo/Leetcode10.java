package com.huanglei.algo;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母，以及字符.和*。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释:因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释:".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释:因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 */

public class Leetcode10 {

    public static void main(String args[]) {

        System.out.println(isMatch("aab", "**c*a*b***"));
        System.out.println(isMatch("aab", "a*b*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aaa", "ab*a*c*a"));
        System.out.println(isMatch("aaa", "aa*"));
        System.out.println(isMatch("", ".*"));
        System.out.println(isMatch("", ""));

    }

    private static char[] trimStars(String pattern) {
        StringBuilder sb = new StringBuilder("");

        int lastStarPos = -1;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                if (i - lastStarPos != 1) {
                    sb.append(pattern.charAt(i));
                }
                lastStarPos = i;
            } else {
                sb.append(pattern.charAt(i));
            }
        }
        System.out.println(sb.toString());
        return sb.toString().toCharArray();
    }

    public static boolean isMatch(String str, String pattern) {
        //去掉连续的*
        char[] p = trimStars(pattern);
        if (str == null || pattern == null) {
            return false;
        }

        char s[] = str.toCharArray();

        boolean dp[][] = new boolean[s.length + 1][p.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == '*' && i >= 1) {
                dp[0][i + 1] = dp[0][i - 1];
            } else {
                dp[0][i + 1] = false;
            }
        }
        for (int i = 1; i < s.length; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (p[j - 1] == s[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p[j - 1] == '*') {
                    if (s[i - 1] == p[j - 2] || p[j - 2] == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        if (j >= 2)
                            dp[i][j] = dp[i][j - 2];
                        else dp[i][j] = false;
                    }
                }

            }
        }
        return dp[s.length][p.length];
    }

}
