package com.leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * 输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi（1<=i<=n）代表每栋楼的高度
 * 输出一行，包含空格分割的n个数字vi，分别代表在第i栋楼时能看到的楼的数量（矮的楼会被高的楼挡住）
 */
public class DandiaoZhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            res[i] +=stack.size();
            while (!stack.empty() && height[i] > stack.peek())
                stack.pop();
            stack.push(height[i]);
        }
        stack.clear();
        for (int i = n-1; i >= 0; i--) {
            res[i] += stack.size();
            while (!stack.empty() && height[i] > stack.peek())
                stack.pop();
            stack.push(height[i]);
        }
        for (int i = 0; i < n; i++) {
            if (i != n-1)
                System.out.printf("%d ", res[i]+1);
            else
                System.out.printf("%d", res[i]+1);
        }
    }

}
