package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 */
public class Main128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        int longestLen = 1;
        for (Integer num: numSet) {
            if (!numSet.contains(num - 1)) {
                int currentLen = 1;
                int curNum = num;
                while (numSet.contains(curNum + 1)) {
                    currentLen += 1;
                    curNum += 1;
                }
                longestLen = Math.max(longestLen, currentLen);
            }
        }
        return longestLen;
    }

    public static void main(String[] args) {
        Main128 m = new Main128();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArr = line.split(" ");
            int[] nums = new int[lineArr.length];
            for (int i = 0; i < lineArr.length; i++) {
                nums[i] = Integer.parseInt(lineArr[i]);
            }
            System.out.println(m.longestConsecutive(nums));
        }

    }
}
