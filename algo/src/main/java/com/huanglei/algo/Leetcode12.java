package com.huanglei.algo;

/**
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
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
 * 给定一个整数，将其转为罗马数字。输入确保在 1到 3999 的范围内。
 * <p>
 * 示例1:
 * <p>
 * 输入:3
 * 输出: "III"
 * 示例2:
 * <p>
 * 输入:4
 * 输出: "IV"
 * 示例3:
 * <p>
 * 输入:9
 * 输出: "IX"
 * 示例4:
 * <p>
 * 输入:58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例5:
 * <p>
 * 输入:1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Leetcode12 {

    public static void main(String args[]) {
        int num = 1994;
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(1000));
        System.out.println(intToRoman(100));
        System.out.println(intToRoman(600));
        System.out.println(intToRoman(2000));
    }

    public static String intToRoman(int num) {
        int step = 0;
        StringBuilder sb = new StringBuilder();
        while (step++ < 3 && num > 0) {
            int remain = num % 10;
            String roman = "";

            if (remain == 5) {
                switch (step) {
                    case 1:
                        roman = "V";
                        break;
                    case 2:
                        roman = "L";
                        break;
                    case 3:
                        roman = "D";
                        break;
                }

            } else if (remain == 9) {
                switch (step) {
                    case 1:
                        roman = "IX";
                        break;
                    case 2:
                        roman = "XC";
                        break;
                    case 3:
                        roman = "CM";
                        break;
                }
            } else if (remain == 4) {
                switch (step) {
                    case 1:
                        roman = "IV";
                        break;
                    case 2:
                        roman = "XL";
                        break;
                    case 3:
                        roman = "CD";
                        break;
                }
            } else if (remain == 0) {
                switch (step) {
                    case 1:
                        roman = "";
                        break;
                    case 2:
                        roman = "";
                        break;
                    case 3:
                        roman = "";
                        break;
                }
            } else if (remain > 0 && remain < 4) {
                while (remain-- > 0) {

                    switch (step) {
                        case 1:
                            roman += "I";
                            break;
                        case 2:
                            roman += "X";
                            break;
                        case 3:
                            roman += "C";
                            break;
                    }
                }
            } else if (remain > 5 && remain < 9) {
                switch (step) {
                    case 1:
                        roman = "V";
                        break;
                    case 2:
                        roman = "L";
                        break;
                    case 3:
                        roman = "D";
                        break;
                }
                while (remain-- > 5) {
                    switch (step) {
                        case 1:
                            roman += "I";
                            break;
                        case 2:
                            roman += "X";
                            break;
                        case 3:
                            roman += "C";
                            break;
                    }
                }
            }
            sb.insert(0, roman);
            num = num / 10;
        }
        while (step >= 3 && num-- > 0) {
            sb.insert(0, "M");
        }
        return sb.toString();
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

}
