package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 */
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
        System.out.println(m.getPermutation(3,3));
    }
}
