package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class Main438_ZiFuChuanZiMuYiWeiCi {
    public List<Integer> findAnagrams(String s, String p) {
        if (p == null || p.isEmpty() || s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        String sortTarget = String.valueOf(pChars);
        int size = pChars.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i + size <= s.length()) {
                char[] tmpChar = s.substring(i, i + size).toCharArray();
                Arrays.sort(tmpChar);
                if (sortTarget.equals(String.valueOf(tmpChar))) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main438_ZiFuChuanZiMuYiWeiCi main = new Main438_ZiFuChuanZiMuYiWeiCi();
        System.out.println(main.findAnagrams("abab", "ab"));
    }
}
