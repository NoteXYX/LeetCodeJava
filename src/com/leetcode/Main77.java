package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Main77 {
    public List<List<Integer>> res = new LinkedList<>();
    public void cur(LinkedList<Integer> curr, int n ,int k, int first) {
        if (curr.size() == k) {
            res.add(new LinkedList<>(curr));
            return;
        }
        for (int i = first; i <= n; i++) {
            curr.add(i);
            cur(curr, n, k, i + 1);
            curr.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> cur = new LinkedList<>();
        cur(cur, n, k, 1);
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Main77 m = new Main77();
        System.out.println(m.combine(n, k));
    }
}
