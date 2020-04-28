package com.leetcode;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Main16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums==null || nums.length<3)
            return 0;
        Arrays.sort(nums);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target)
                    return sum;
                int curMin = Math.abs(sum - target);
                if (curMin < min) {
                    res = sum;
                    min = Math.abs(sum - target);
                }
                if (sum < target)
                    left++;
                else if (sum > target)
                    right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main16 m = new Main16();
        int[] nums = {0,2,1,-3};
        int target = 1;
        System.out.println(m.threeSumClosest(nums, target));
    }

}
