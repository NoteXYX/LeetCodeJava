package com.leetcode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 473. 火柴拼正方形
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 * 输入: [1,1,2,2,2]
 * 输出: true
 */
public class Main473 {
    private List<Integer> nums;
    private int[] sums;
    private int possibleSide;
    public Main473() { this.sums = new int[4]; }
    public boolean dfs(int index) {
        if (index == nums.size())
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        int curSide = nums.get(index);
        for (int i = 0; i < 4; i++) {
            if (sums[i] + curSide <= possibleSide) {
                sums[i] += curSide;
                if (dfs(index + 1))
                    return true;
                sums[i] -= curSide;
            }
        }
        return false;
    }
    public boolean makesquare(int[] nums) {
        if (nums==null || nums.length<4)
            return false;
        int totalLen = 0;
        for (int num: nums) {
            totalLen += num;
        }
        this.possibleSide = totalLen / 4;
        if (this.possibleSide * 4 != totalLen)
            return false;
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        this.nums.sort(((o1, o2) -> o2 - o1));
        return dfs(0);
    }
}


//
//private List<Integer> nums;
//    private int[] sums;
//    private int possibleSquareSide;
//
//    public Main473() {
//        this.sums = new int[4];
//    }
//    public boolean dfs(int index) {
//        if (index == this.nums.size()) {
//            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
//        }
//        int element = this.nums.get(index);
//        for(int i = 0; i < 4; i++) {
//            if (this.sums[i] + element <= this.possibleSquareSide) {
//                this.sums[i] += element;
//                if (this.dfs(index + 1)) {
//                    return true;
//                }
//                this.sums[i] -= element;
//            }
//        }
//        return false;
//    }
//
//    public boolean makesquare(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return false;
//        }
//        int perimeter = 0;//所有火柴长度总和
//        for (int num : nums) {
//            perimeter += num;
//        }
//        this.possibleSquareSide =  perimeter / 4;
//        if (this.possibleSquareSide * 4 != perimeter) {
//            return false;
//        }
//        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        Collections.sort(this.nums, Collections.reverseOrder());
//        return this.dfs(0);
//    }