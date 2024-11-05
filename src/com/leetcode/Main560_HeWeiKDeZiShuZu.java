package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Main560_HeWeiKDeZiShuZu {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> sum2Count = new HashMap<>();
        sum2Count.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum2Count.containsKey(sum - k)) {
                count += sum2Count.get(sum - k);
            }
            sum2Count.put(sum, sum2Count.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 2, 3};
        int k = 5;
        Main560_HeWeiKDeZiShuZu main = new Main560_HeWeiKDeZiShuZu();
        System.out.println(main.subarraySum(nums, k));
    }
}
