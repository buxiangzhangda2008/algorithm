package com.huanglei.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */

public class Leetcode20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('#');
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.pop() != '{')
                        return false;
                    break;
            }
        }
        return stack.pop() == '#';

    }

    public static void main(String[] args) {
//        String[] symbols = {"(",")","{","}","[","]"};
        System.out.println(isValid(""));
        System.out.println(isValid("]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()[]{"));
        System.out.println(isValid("{[]"));
    }
}
