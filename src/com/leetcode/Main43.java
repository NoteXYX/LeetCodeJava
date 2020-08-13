package com.leetcode;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class Main43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        int[] tmp = new int[m+n];
        for (int i = m-1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n-1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int sum = tmp[i+j+1] + x * y;
                tmp[i+j+1] = sum % 10;
                tmp[i+j] += sum / 10;
            }
        }
        for (int i = 0; i < m+n; i++) {
            if (i == 0 && tmp[i] == 0)
                continue;
            res.append(tmp[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Main43 m = new Main43();
        String num1 = "123";
        String num2 = "456";
        System.out.println(m.multiply(num1, num2));
    }
}
