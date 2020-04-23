package com.leetcode;

import sun.applet.Main;

import java.util.Arrays;

/**
 * 13. 罗马数字转整数
 */
public class Main13 {
    public int romanToInt(String s) {
        if (s==null || s.length()==0)
            return 0;
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            if (i+1 < s.length() && getValue(s.charAt(i))<getValue(s.charAt(i+1)))
                res -= getValue(s.charAt(i));
            else
                res += getValue(s.charAt(i));
            i++;
        }
        return res;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Main13 m = new Main13();
        System.out.println(m.romanToInt("IV"));
    }

}
