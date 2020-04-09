package com.company;
public class quickMi {
    public int myPow(int a, int b) {
        int base = a;
        int res = 1;
        while (b != 0) {
            if ((b & 1) == 1)
                res *= base;
            base *= base;
            b >>>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        quickMi m = new quickMi();
        System.out.println(m.myPow(3,3));
    }
}
