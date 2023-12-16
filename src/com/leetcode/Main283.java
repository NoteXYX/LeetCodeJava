package com.leetcode;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 */
public class Main283 {
    public void moveZeroes(int[] nums) {
        int first = 0;
        int second = 0;
        while (second < nums.length) {
            if (nums[second] != 0) {
                nums[first] = nums[second];
                second += 1;
                first += 1;
            } else {
                second += 1;
            }
        }
        while (first < nums.length) {
            nums[first] = 0;
            first += 1;
        }
    }

    public static void main(String[] args) {
        Main283 main283 = new Main283();
        int[] nums = {0};
        main283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
