package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class Main215_TopK {
    public int findKthLargest0(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            }
            else {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        return pq.peek();
    }
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        int heapSize = nums.length;
        buildHeap(nums, heapSize);
        for (int i = nums.length-1; i > nums.length-k; i--) {
            swap(nums, 0, i);
            heapSize--;
            heapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildHeap(int[] nums, int heapSize) {
        for (int i = (heapSize - 2) / 2; i >= 0; i--) {
            heapify(nums, i, heapSize);
        }
    }

    public void heapify(int[] nums, int curNode, int heapSize) {
        int l = curNode * 2 + 1;
        int r = curNode * 2 + 2;
        int largest = curNode;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != curNode) {
            swap(nums, curNode, largest);
            heapify(nums, largest, heapSize);
        }
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        Main215_TopK m = new Main215_TopK();
        System.out.println(m.findKthLargest(nums, k));
    }
}
