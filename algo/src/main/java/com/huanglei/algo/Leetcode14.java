package com.huanglei.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Leetcode14 {

    public static void main(String args[]) {
//        String strs[] = {"flower","flow","flight"};
        String strs[] = {};
        String strs1[] = {"flower", "flow", "floight"};
        String strs2[] = {"aaabbd", "aaabbc", "aaabb"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
    }


    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        int pos = 0;
        char tmp = '0';
        for (int i = 0; i < strs.length; ) {

            String str = strs[i];
            if (pos > str.length() - 1) {
                pos = pos - 1;
                break;
            }
            if (tmp == '0') {
                tmp = str.charAt(pos);
            } else {
                if (tmp != str.charAt(pos)) {
                    pos = pos - 1;
                    break;
                }
            }
            if (i == strs.length - 1) {
                pos++;
                i = 0;
                tmp = '0';
            } else {
                i++;
            }
        }
        if (pos >= 0) {
            return strs[0].substring(0, pos + 1);
        }
        return "";
    }
}
