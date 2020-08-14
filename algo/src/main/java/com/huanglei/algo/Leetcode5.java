package com.huanglei.algo;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Leetcode5 {

    public static void main(String args[]) {
        System.out.println(longestPalindrome2("aacdefcaa"));
        System.out.println(longestPalindrome2("bbbaaccaaefghkkk"));
        System.out.println(longestPalindrome2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }


    /**
     * 翻转字符串，比较最长公共子串，通过位置关系除去非回文的公共子串
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.isEmpty())
            return "";
        String str1 = s;
        String str2 = reverseStr(s);
        return longestCommonStr(str1, str2);
    }

    /**
     * 中心扩散法，一共2n-1个中心，遍历每个中心，由中心向外扩散，找到回文记录，比较每个中心点的回文，最长的就是结果
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s.isEmpty())
            return "";
        String longestStr = "";
//        char schar[] = s.toCharArray();
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            int m, n;
            if (i % 2 == 0) {
                //偶数即为数组真实下标
                m = n = i / 2;
            } else {
                //奇数为中间前后两位
                m = i / 2;
                n = i / 2 + 1;
            }

            String lstr = "";
            while (m >= 0 && n <= (s.length() - 1) && s.charAt(m) == s.charAt(n)) {
                lstr = s.substring(m--, 1 + n++);
            }
            longestStr = lstr.length() > longestStr.length() ? lstr : longestStr;
//            }
        }
        return longestStr;
    }

    public static String reverseStr(String str) {
        char[] strArr = str.toCharArray();
        char[] retArr = new char[strArr.length];
        for (int i = 0, j = strArr.length - 1; i < strArr.length & j >= 0; i++, j--) {
            retArr[i] = strArr[j];
        }
        return new String(retArr);
    }

    public static String longestCommonStr(String str1, String str2) {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < str2.length() + 1; j++) {
            dp[0][j] = 0;
        }
        int longLen = 0;
        int pos = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    int start = (i - 1);
                    //翻转之前的位置
                    int beforeReverse = str2.length() - 1 - (j - 1);
                    if (beforeReverse + dp[i][j] - 1 == start) {
                        if (dp[i][j] > longLen) {
                            longLen = dp[i][j];
                            pos = i - 1;
                        }
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return str1.substring(pos - longLen + 1, pos + 1);
    }
}
