package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 1329. 将矩阵按对角线排序
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。
 *输入：mat = [[3,3,1,1],
 *            [2,2,1,2],
 *            [1,1,1,2]]
 * 输出：[[1,1,1,1],
 *       [1,2,2,2],
 *       [1,2,3,3]]
 */
public class Main1329 {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int row = 0;
        int col = 0;
        int oldRow = 0;
        int oldCol = 0;
        int tmpIndex = 0;
        int[][] res = new int[rows][cols];
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < rows+cols-1; i++) {
            row = i < rows ? rows-1-i : 0;
            col = i >= rows ? i-rows+1 : 0;
            oldRow = row;
            oldCol = col;
            tmp.clear();
            while (row < rows && col < cols) {
                tmp.add(mat[row][col]);
                row++;
                col++;
            }
            tmp.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            row = oldRow;
            col = oldCol;
            tmpIndex = 0;
            while (row < rows && col < cols) {
                res[row][col] = tmp.get(tmpIndex);
                row++;
                col++;
                tmpIndex++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        Main1329 m = new Main1329();
        int[][] res = m.diagonalSort(mat);
    }
}
