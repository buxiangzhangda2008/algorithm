package com.huanglei.algo;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

public class Leetcode17 {

    public static void main(String args[]) {
        System.out.println(letterCombinations("23"));

    }

    public static List letterCombinations(String digits) {
        Map<String, char[]> map = new HashMap<>();
        map.put("2", "abc".toCharArray());
        map.put("3", "def".toCharArray());
        map.put("4", "ghi".toCharArray());
        map.put("5", "jkl".toCharArray());
        map.put("6", "mno".toCharArray());
        map.put("7", "pqrs".toCharArray());
        map.put("8", "tvu".toCharArray());
        map.put("9", "wxyz".toCharArray());
        List<String>[] dp = new ArrayList[digits.length()];

        List<String> arr = new ArrayList();
        char[] cs = map.get(digits.substring(0, 1));
        for (int i = 0; i < cs.length; i++) {
            arr.add(cs[i] + "");
        }
        dp[0] = arr;
        for (int j = 1; j < dp.length; j++) {
            dp[j] = append(dp[j - 1], map.get(digits.substring(j, j + 1)));
        }
        return dp[digits.length() - 1];
    }

    public static List append(List<String> a, char[] b) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            for (String str : a) {
                ret.add(str + b[i]);
            }
        }
        return ret;
    }
}
