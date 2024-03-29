package com.huanglei.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做  XXVII, 即为XX+V+II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 * <p>
 * 示例1:
 * <p>
 * 输入:"III"
 * 输出: 3
 * 示例2:
 * <p>
 * 输入:"IV"
 * 输出: 4
 * 示例3:
 * <p>
 * 输入:"IX"
 * 输出: 9
 * 示例4:
 * <p>
 * 输入:"LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例5:
 * <p>
 * 输入:"MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Leetcode13 {

    public static void main(String args[]) {
        System.out.println(romanToIit("III"));
        System.out.println(romanToIit("IV"));
        System.out.println(romanToIit("IX"));
        System.out.println(romanToIit("LVIII"));
        System.out.println(romanToIit("MCMXCIV"));
        System.out.println(romanToIit("XLV"));
    }


    public static int romanToIit1(String roman) {

        Map<String, Integer> romans = new HashMap<>();
        romans.put("M", 1000);
        romans.put("CM", 900);
        romans.put("D", 500);
        romans.put("CD", 400);
        romans.put("C", 100);
        romans.put("XC", 90);
        romans.put("L", 50);
        romans.put("XL", 40);
        romans.put("X", 10);
        romans.put("IX", 9);
        romans.put("V", 5);
        romans.put("IV", 4);
        romans.put("I", 1);

        int ret = 0;
        String currentKey = null;
        String nextKey = null;
        for (int i = 0; i < roman.length(); i++) {
            if (nextKey != null) {
                currentKey = nextKey;
            } else {
                currentKey = roman.substring(i, i + 1);
            }
            if (i < roman.length() - 1) {
                nextKey = roman.substring(i + 1, i + 2);
            }
            Integer value = romans.get(currentKey + nextKey);
            if (value != null) {
                ret += value;
                nextKey = null;
                i++;
            } else {
                ret += romans.get(currentKey);
            }
        }
        return ret;
    }

    public static int romanToIit(String roman) {

        int ret = 0;
        int currentNum = getValue(roman.charAt(0));
        for (int i = 1; i < roman.length(); i++) {
            int nextNum = getValue(roman.charAt(i));
            if (nextNum > currentNum) {
                ret -= currentNum;
            } else {
                ret += currentNum;
            }
            currentNum = nextNum;
        }
        ret += currentNum;
        return ret;
    }

    public static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
