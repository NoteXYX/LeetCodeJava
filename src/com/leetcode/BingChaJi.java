package com.leetcode;

import java.util.Scanner;

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        BingChaJi bingChaJi = new BingChaJi();
        bingChaJi.init(n);
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            bingChaJi.merge(x, y);
        }
        for (int i = 0; i < p; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (bingChaJi.find(x) == bingChaJi.find(y)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
