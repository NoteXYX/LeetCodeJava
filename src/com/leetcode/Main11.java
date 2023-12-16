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
        if (height == null || height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxMl = Math.min(height[left], height[right]) * (right - left);
        while (left != right) {
            if (height[left] <= height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
            if (left != right) {
                maxMl = Math.max(maxMl, Math.min(height[left], height[right]) * (right - left));
            }
        }
        return maxMl;
    }

    public static void main(String[] args) {
        Main11 m = new Main11();
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(m.maxArea(height));
    }
}
