package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static double findMaxProduct(double[] a)
    {
        int num = a.length;
        double maxProduct=a[0];
        double maxEnd=a[0];  //记录当前最大值
        double minEnd=a[0];  //记录当前最小值，因为后面会出现负数的话，当前的最小值就会逆袭~！
        for (int i=1; i<num; i++)
        {
            maxEnd=Math.max(Math.max(maxEnd*a[i], minEnd*a[i]), a[i]);  //更新当前最大值
            minEnd=Math.min(Math.min(maxEnd*a[i], minEnd*a[i]), a[i]);   //更新当前最小值
            maxProduct=Math.max(maxEnd, maxProduct);   //乘积最大值一定是二选一
        }
        return maxProduct;
    }
    public int[] divingBoard(int shorter, int longer, int k) {
        int[] res = new int[0];
        if (k <= 0)
            return res;
        Set<Integer> resSet = new LinkedHashSet<>();
        for (int i = 0; i <= k; i++) {
            resSet.add(shorter * i + longer * (k-i));
        }
        return resSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        double[] a = {-2.5, 4, 0, 3, 0.5, 8, -1};
        double maxProduct=findMaxProduct(a);
        System.out.println(maxProduct);
        Main m = new Main();
        int shorter = 1;
        int longer = 2;
        int k = 3;
        System.out.println(Arrays.toString(m.divingBoard(shorter, longer, k)));

    }

}
