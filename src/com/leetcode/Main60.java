package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Main60 {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++)
            factorial[i] = i * factorial[i-1];
        StringBuilder res = new StringBuilder();
        while (n > 0){
            int svIndex = (int)Math.ceil((double)k / factorial[n-1]) - 1;
            if (svIndex == -1)
                svIndex = num.size()-1;
            int sv = num.get(svIndex);
            num.remove(svIndex);
            res.append(sv);
            k %= factorial[n-1];
            n--;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Main60 m = new Main60();
        System.out.println(m.getPermutation(4,5));
    }
}
