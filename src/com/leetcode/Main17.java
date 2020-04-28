package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Main17 {
    HashMap<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> list = new ArrayList<>();
    public void recur(String combine, String digits) {
        if (digits.length() == 0)
            list.add(combine);
        else {
            String letters = map.get(digits.substring(0,1));
            for (int i = 0; i < letters.length(); i++) {
                recur(combine + letters.substring(i,i+1), digits.substring(1));
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits!=null && digits.length() > 0)
            recur("", digits);
        return list;
    }

    public static void main(String[] args) {
        Main17 m = new Main17();
        String digits = "23";
        System.out.println(m.letterCombinations(digits));
    }
}
