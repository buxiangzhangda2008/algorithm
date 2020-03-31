package com.huanglei.algo;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
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
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
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
 */
public class Leetcode10 {

    public static void main(String args[]) {
//        System.out.println(isMatch(121));
//        System.out.println(isMatch(-121));
    }

    /**
     * @return
     */
    public static boolean isMatch(String str, String pattern) {
        // dp[i][j]
        // i str中的位置
        //j pattern中位置
        //dp[i][j]表示 str到i 与pattern到j 是否匹配
        //dp[m][n]是否为true

        //转换公式
        /**
         * dp[i][j] = { if(dp[i-1][j-1] = true)
         *                  if(p[j-1]=.) 判断p[j]与s[i]是否相等
         *                  if(p[j-1]=*) {
         *                      1\判断前一个不为*的值与s[i]是否相等 dp[i][j-1] = true;
         *                          if not
         *                          p[j]==s[i]?
         *                      }
         *                  if(p[j-1]=a) 判断p[j]==s[i]
         *                  : dp[i][j]
         *              if(dp[i-1][j-1] = false
         *                   p[j]  1,2,3
         *                  dp[i-1][j]是否匹配
         *
         *                  dp[i][j]是否匹配
         *                  dp[i][j-1]是否匹配
         */

        boolean dp[][] = new boolean[str.length() + 1][pattern.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = false;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
//                if (dp[i - 1][j - 1]) {
                    char preP = pattern.charAt(j - 1);
                    if (isAZ(preP) || preP == '.') {
                        //a-z
                        dp[i][j - 1] = false;
                        dp[i - 1][j] = false;
                        char pChar = pattern.charAt(j - 1);
                        if (pChar == '*') {
                            dp[i][j] = str.charAt(i - 1) == preP || preP == '.';
                        } else {
                            dp[i][j] = str.charAt(i - 1) == pChar || pChar == '.';
                        }
                    }
                    if (preP == '*') {
                        char c = str.charAt(i - 1);
                        int k = 0;
                        //first not *
                        for (k = j - 2; k >= 0; k--) {
                            if (pattern.charAt(k) != '*')
                                break;
                        }
                        dp[i][j] = pattern.charAt(k) == c || pattern.charAt(k) == '.';

                        dp[i][j-1] = pattern.charAt(k) == c || pattern.charAt(k) == '.';
                        dp[i-1][j] = true;
                    }
//                } else {
//
//                }
            }
        }
    }

    public static boolean isAZ(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

}
