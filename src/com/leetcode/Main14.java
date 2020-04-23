package com.leetcode;

/**
 * 14. 最长公共前缀
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class Main14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0)
            return "";
        if (strs.length == 1)
            return strs[0];
        StringBuilder sbd = new StringBuilder();
        int i = 0;
        while (i < strs[0].length() && i < strs[1].length()) {
            if (strs[0].charAt(i) == strs[1].charAt(i)) {
                sbd.append(strs[0].charAt(i));
                i++;
            }
            else
                break;
        }
        i = 2;
        while (i < strs.length && sbd.length()>0) {
            while (sbd.length()>0 && !strs[i].startsWith(sbd.toString())) {
                sbd.deleteCharAt(sbd.length()-1);
            }
            i++;
        }
        return sbd.toString();
    }

    public static void main(String[] args) {
        Main14 m = new Main14();
        String[] strs = {"dog","racecar","car"};
        System.out.println(m.longestCommonPrefix(strs));
    }
}
