package com.leetcode;


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
public class Main15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
               if (left != i + 1 && nums[left] == nums[left - 1]) {
                   left++;
               } else if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                   right--;
               } else {
                   if (nums[i] + nums[left] + nums[right] > 0) {
                       right--;
                   } else if (nums[i] + nums[left] + nums[right] < 0) {
                       left++;
                   } else {
                       res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                       left++;
                       right--;
                   }
               }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main15_ThreeSum m = new Main15_ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(m.threeSum(nums));
    }

}
