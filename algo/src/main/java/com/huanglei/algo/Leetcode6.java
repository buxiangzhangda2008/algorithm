package com.huanglei.algo;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * LCIRETOESIIGEDHN
 * LCIRETOESIIGEDHN
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * LDREOEIIECIHNTSG
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Leetcode6 {

    public static void main(String args[]) {
        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println(convert("LEETCODEISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder sbs[] = new StringBuilder[numRows];

        int preLine = 0;
        for (int i = 0, j = 0; i < s.length() && j < numRows && j >= 0; i++) {
            int tmp = j;
            if (sbs[j] == null) {
                sbs[j] = new StringBuilder();
            }
            sbs[j].append(s.charAt(i));
            j = nextLineNumber(j, preLine, numRows);
            preLine = tmp;
        }

        StringBuilder ret = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            ret.append(sbs[j].toString());
        }
        return ret.toString();
    }

    public static String convert2(String s, int numRows) {
        if (numRows <= 1) return s;
        char ret[] = new char[s.length()];
        int step = numRows * 2 - 2;
        int lpos = 0, rpos = 0, row = 0;
        for (int i = 0; i < ret.length; i++) {
            if (row == 0 || row == numRows - 1) {
                ret[i] = s.charAt(lpos);
            } else {
                ret[i] = s.charAt(lpos);
                ret[++i] = s.charAt(rpos);
            }
            lpos += step;
            rpos += step;
            if (lpos > s.length()) {
                row += 1;
            }
        }

        return ret.toString();
    }

    public static int nextLineNumber(int pre, int prepre, int numRows) {
        if (pre == 0) {
            return pre + 1;
        }
        if (pre == numRows - 1 || pre < prepre) {
            return pre - 1;
        }
        return pre + 1;

    }

}
