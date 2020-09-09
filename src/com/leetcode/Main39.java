package com.leetcode;

import java.util.*;

public class Main39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0)
            return res;
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, len, deque, target, res);
        return res;
    }
    public void dfs(int[] candidates, int begin, int len, Deque<Integer> deque, int target, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0)
                break;
            deque.addLast(candidates[i]);
            dfs(candidates, i, len, deque, target-candidates[i], res);
            deque.removeLast();
        }

    }
}
