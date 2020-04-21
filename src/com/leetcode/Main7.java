package com.leetcode;
/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: -123
 * 输出: -321
 */
public class Main7 {
    public int reverse(int x) {
        int tmp = 0;
        int res = 0;
        while (x != 0) {
            tmp = 10 * res + x % 10;
            if ((tmp - x %10) / 10 != res)
                return 0;
            res = tmp;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Main7 m = new Main7();
        int x = -123;
        System.out.println(m.reverse(x));

    }

}
