package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"

 */
public class Main22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        dfs(res, "", n, n);
        return res;
    }
    public void dfs(List<String> res, String str, int l, int r) {
        if (l == 0 && r == 0) {
            res.add(str);
            return;
        }
        if (l > r) {
            return;
        }
        if (l > 0) {
            dfs(res, str + "(", l-1, r);
        }
        if (r > 0) {
            dfs(res, str + ")", l, r-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Main22 m = new Main22();
        System.out.println(m.generateParenthesis(n));
    }
}
