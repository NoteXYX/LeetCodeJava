package com.leetcode;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 双指针法
 */
public class Main15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length<3)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i]==nums[i-1])
                continue;
            int left = i + 1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left<right && nums[right] == nums[right-1])
                        right--;
                    while (left<right && nums[left] == nums[left+1])
                        left++;
                    left++;
                    right--;
                }
                else if (sum < 0)
                    left++;
                else if (sum>0)
                    right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main15 m = new Main15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(m.threeSum(nums));
    }

}
