package com.leetcode;

/**
 * 8. 字符串转换整数 (atoi)
 *
 */
public class Main8 {
    public int myAtoi(String str) {
        boolean start = false;
        char curChar = ' ';
        int fuhao = 1;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            curChar = str.charAt(i);
            if (!start) {
                if (curChar == '-') {
                    fuhao = -1;
                    start = true;
                }
                else if (curChar == '+')
                    start = true;
                else if (curChar>='0' && curChar<='9') {
                    res = res * 10 + curChar - '0';
                    start = true;
                }
                else if (curChar != ' ' && curChar != '+')
                    break;
            }
            else {
                if (curChar>='0' && curChar<='9') {
                    if (res > (Integer.MAX_VALUE - curChar + '0') / 10)
                        return fuhao==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    else
                        res = res * 10 + curChar - '0';
                }
                else
                    break;
            }
        }
        if (start)
            res = res * fuhao;
        return res;
    }

    public static void main(String[] args) {
        Main8 m = new Main8();
        String str = "42";
        System.out.println(m.myAtoi(str));
    }
}
