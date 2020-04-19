package com.leetcode;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class Main6 {
    public String convert(String s, int numRows) {
        StringBuffer sbf = new StringBuffer();
        if (s==null || s.length()==0)
            return sbf.toString();
        if (s.length()==1 || numRows==1)
            return s;
        int start = 0;
        while (start < numRows) {
            int first = start;
            if (first == numRows-1 || first == 0) {
                while (first < s.length()) {
                    sbf.append(s.charAt(first));
                    first = first + 2 * (numRows-1);
                }
            }
            else {
                while (first < s.length()) {
                    sbf.append(s.charAt(first));
                    first = first + 2 * (numRows-start-1);
                    if (first < s.length()) {
                        sbf.append(s.charAt(first));
                        first = first + 2 * start;
                    }
                }
            }
            start++;
        }
        return sbf.toString();
    }

    public static void main(String[] args) {
        Main6 m = new Main6();
        String s = "AB";
        System.out.println(m.convert(s, 1));
    }
}
