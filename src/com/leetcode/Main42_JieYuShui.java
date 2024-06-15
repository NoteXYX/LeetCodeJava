package com.leetcode;

import java.util.Stack;

/**
 * 42. 接雨水
 */
public class Main42_JieYuShui {
    public int trapDandiaoZhan(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }

    public int trapDoubleCurser(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left != right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                // 可以放心计算左指针所在柱子的雨水量
                res += leftMax - height[left];
                left += 1;
            } else {
                // 可以放心计算右指针所在柱子的雨水量
                res += rightMax - height[right];
                right -= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] req = {4,2,0,3,2,5};
        Main42_JieYuShui main42 = new Main42_JieYuShui();
        System.out.println(main42.trapDoubleCurser(req));
    }
}
