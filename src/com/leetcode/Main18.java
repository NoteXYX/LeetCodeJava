package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 */
public class Main18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length < 4)
            return res;
        int length = nums.length;
        Arrays.sort(nums);
        for (int firstNum = 0; firstNum < length-3; firstNum++) {
            if (firstNum > 0 && nums[firstNum-1] == nums[firstNum])
                continue;
            int min1 = nums[firstNum] + nums[firstNum+1] + nums[firstNum+2] + nums[firstNum+3];
            if (min1 > target)
                break;
            int max1 = nums[firstNum] + nums[length-3] + nums[length-2] + nums[length-1];
            if (max1 < target)
                continue;
            for (int secondNum = firstNum+1; secondNum < length-2; secondNum++) {
                if (secondNum > firstNum+1 && nums[secondNum] == nums[secondNum-1])
                    continue;
                int min2 = nums[firstNum] + nums[secondNum] +  nums[secondNum+1] + nums[secondNum+2];
                if (min2 > target)
                    break;
                int max2 = nums[firstNum] + nums[secondNum] +  nums[length-2] + nums[length-1];
                if (max2 < target)
                    continue;
                int left = secondNum + 1;
                int right = length-1;
                while (left < right) {
                    int cur = nums[firstNum] + nums[secondNum] +  nums[left] + nums[right];
                    if (cur == target) {
                        res.add(Arrays.asList(nums[firstNum], nums[secondNum], nums[left], nums[right]));
                        left++;
                        while (left < right && nums[left] == nums[left-1])
                            left++;
                        right--;
                        while (right > left && nums[right] == nums[right+1])
                            right--;
                    }
                    else if (cur < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Main18 m = new Main18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(m.fourSum(nums, target));
    }


}
