package com.huanglei.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
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

    static List<String> results = new ArrayList<>();

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
        new Leetcode22().generate(3);
        for (String s : results) {
            System.out.println(s);
        }
    }

        StringBuilder ret = new StringBuilder("");
    public void generate(int n) {
        if (totalLeft < n || totalRight < n) {
            if(tryAccquireLeft(ret,n)) {
                //rollback
                ret.delete(ret.length() - 1, ret.length());
                totalLeft--;
            }else {
                tryAccquireRight(ret, n);
            }
        }else{
            results.add(ret.toString());
            return;
        }
        generate(n);
    }

    int totalLeft = 0;
    int totalRight = 0;
    String left = "(";
    String right = ")";

    private boolean tryAccquireLeft(StringBuilder ret, int n) {
        //do left
        if (totalLeft < n) {
            totalLeft++;
            ret.append(left);
            return true;
        }
        return false;
    }


    private void tryAccquireRight(StringBuilder ret, int n) {
        if (totalRight + 1 <= n && totalRight < totalLeft) {
            totalRight++;
            ret.append(right);
        }
    }



}
