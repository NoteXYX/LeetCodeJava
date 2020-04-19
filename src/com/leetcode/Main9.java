package com.leetcode;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Main9 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int weishu = 1;
        int tmp = weishu * 10;
        boolean res = true;
        while (tmp <= x) {
            tmp *= 10;
            weishu++;
        }
        int curWei = 1;
        int beginChu = (int)(Math.pow(10, weishu-1));
        int begin = 0;
        int end = 0;
        tmp = x;
        while (curWei <= weishu/2) {
            end = tmp % 10;
            begin = tmp / beginChu;
            if (end != begin)
                return false;
            tmp -= begin * beginChu;
            tmp /= 10;
            beginChu /= 100;
            curWei++;
        }
        return res;
    }

    public static void main(String[] args) {
        Main9 m = new Main9();
        System.out.println(m.isPalindrome(11));
    }
}
