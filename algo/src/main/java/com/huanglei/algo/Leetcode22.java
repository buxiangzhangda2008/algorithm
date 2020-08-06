package com.huanglei.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Leetcode22 {

    List<String> results = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        chooseNext("", 0, 0, n);
        return results;
    }

    private void chooseNext(String currStr, int useLeft, int useRight, int totalSize) {
        if (useLeft == totalSize && useRight == totalSize) {
            results.add(currStr);
            return;
        }

        if (useLeft < useRight) {
            return;
        }
        if (useLeft < totalSize) {

            chooseNext(currStr + "(", useLeft + 1, useRight, totalSize);
        }
        if (useRight < totalSize) {
            chooseNext(currStr + ")", useLeft, useRight + 1, totalSize);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Leetcode22().generateParenthesis(3);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
