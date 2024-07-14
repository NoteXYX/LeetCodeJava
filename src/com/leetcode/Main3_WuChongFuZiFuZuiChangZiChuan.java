//无重复字符的最长子串
package com.leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 *  的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Main3_WuChongFuZiFuZuiChangZiChuan {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstringMap(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> char2Pos = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length() && left < s.length()) {
            Character rightChar = s.charAt(right);
            if (!char2Pos.containsKey(rightChar)) {
                // 无重复的字符
                char2Pos.put(rightChar, right);
                res = Math.max(res, right - left + 1);
                right += 1;
            } else {
                // 有重复的字符
                int newLeft = char2Pos.get(rightChar) + 1;
                for (int i = left; i < newLeft; i++) {
                    char2Pos.remove(s.charAt(i));
                }
                left = newLeft;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main3_WuChongFuZiFuZuiChangZiChuan main = new Main3_WuChongFuZiFuZuiChangZiChuan();
        String s = "bbbbbbbbbbbbbbbbb";
        System.out.println(main.lengthOfLongestSubstringMap(s));
    }
}
