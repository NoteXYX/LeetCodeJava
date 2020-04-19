package com.leetcode;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai)
 * 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class Main11 {
    public int maxArea(int[] height) {
        if (height==null || height.length<=1)
            return 0;
        int max = 0;
        int l = 0;
        int r = height.length-1;
        int curCap = 0;
        while (l < r) {
            curCap = (r-l) * Math.min(height[l], height[r]);
            if (curCap > max)
                max = curCap;
            if (height[l] <= height[r])
                l++;
            else
                r--;
        }
        return max;
    }

    public static void main(String[] args) {
        Main11 m = new Main11();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(m.maxArea(height));
    }
}
