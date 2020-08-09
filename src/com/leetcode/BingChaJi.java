package com.leetcode;

public class BingChaJi {
    public int[] father = new int[1000];
    public int[] rank = new int[1000];
    public void init(int n) {
        for (int i = 1; i <= n; i++) {
            father[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x) {
        return x == father[x] ? x : (father[x] = find(father[x]));
    }
    public void merge(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (rank[x] <= rank[y]) {
            father[x] = y;
        } else {
            father[y] = x;
        }
        if (rank[x] == rank[y] && x != y) {
            rank[y]++;
        }
    }
}
