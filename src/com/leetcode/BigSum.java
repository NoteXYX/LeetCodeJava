package com.leetcode;

public class BigSum {
    public StringBuffer bigSum(String a, String b) {
        StringBuffer sbf_a = new StringBuffer(a);
        StringBuffer sbf_b = new StringBuffer(b);
        int diffNum = 0;
        if (sbf_a.length() > sbf_b.length()) {
            diffNum = sbf_a.length() - sbf_b.length();
            for (int i = 0; i < diffNum; i++) {
                sbf_b.insert(0, '0');
            }
        }
        else {
            diffNum = sbf_b.length() - sbf_a.length();
            for (int i = 0; i < diffNum; i++) {
                sbf_a.insert(0, '0');
            }
        }
        int carry = 0;
        int curSum = 0;
        StringBuffer res = new StringBuffer();
        for (int i = sbf_a.length()-1; i >= 0; i--) {
            curSum = sbf_a.charAt(i) + sbf_b.charAt(i) - 2 * '0' + carry;
            res.insert(0, curSum % 10);
            carry = curSum / 10;
        }
        if (carry == 1)
            res.insert(0, '1');
        return res;
    }
    public static void main(String[] args) {
        BigSum m = new BigSum();
        String a = "1119111";
        String b = "91911";
        System.out.println(m.bigSum(a, b));
    }
}
