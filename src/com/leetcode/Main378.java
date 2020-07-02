package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 */
public class Main378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int lineNum = matrix.length;
        for (int i = 0; i < lineNum; i++) {
            priorityQueue.offer(new int[] {matrix[i][0], i, 0});
        }
        for (int i = 0; i < k-1; i++) {
            int[] num = priorityQueue.poll();
            if (num[2] != lineNum-1) {
                priorityQueue.offer(new int[] {matrix[num[1]][num[2]+1], num[1], num[2]+1});
            }
        }
        return priorityQueue.peek()[0];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9},
                          {10, 11, 13},
                          {12, 13, 15}};
        Main378 m = new Main378();
        int k = 8;
        System.out.println(m.kthSmallest(matrix, k));
    }
}
