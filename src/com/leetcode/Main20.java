package com.leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  输入: "()[]{}"
 *  输出: true
 *  示例 3:
 *
 *  输入: "(]"
 *  输出: false
 */
public class Main20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }
                }
                if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }
                }
                if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                        continue;
                    }
                }
                return false;
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        Main20 m = new Main20();
        String s = "{{{";
        System.out.println(m.isValid(s));
    }
}




