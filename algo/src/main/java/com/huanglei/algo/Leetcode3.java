package com.huanglei.algo;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Leetcode3 {

    public static void main(String args[]) {
        System.out.println(solution("abcabcbb"));
        System.out.println(solution("bbbbb"));
        System.out.println(solution("pwwkew"));
        System.out.println(solution("abcabcbb"));
        System.out.println(solution("au"));
    }


    public static int solution(String str) {
        char[] arrStr = str.toCharArray();
        if (arrStr.length == 0) return 0;
        int maxLen = 1;
        int pos = 0;
        for (int i = 1; i < arrStr.length; i++) {
            for (int j = pos; j < i; j++) {
                if (arrStr[i] == arrStr[j]) {
                    pos = j + 1;
                    break;
                }
            }
            maxLen = Math.max(maxLen, i - pos + 1);
        }
        return maxLen;
    }
}
