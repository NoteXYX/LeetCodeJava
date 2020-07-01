package com.leetcode;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Main31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int firstLow = nums.length-2;
        while (firstLow >= 0) {
            if (nums[firstLow] < nums[firstLow+1]) {
                break;
            }
            firstLow -= 1;
        }
        if (firstLow == -1) {
            nixu(nums, 0, nums.length-1);
        }
        else {
            int firstBigger = nums.length-1;
            while (nums[firstBigger] <= nums[firstLow]) {
                firstBigger -= 1;
            }
            swap(nums, firstBigger, firstLow);
            nixu(nums, firstLow+1, nums.length-1);
        }
    }
    public void nixu(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start += 1;
            end -= 1;
        }
    }
    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,1};
        Main31 m = new Main31();
        m.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
