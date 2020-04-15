package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 */
public class Main498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0)
            return new int[0];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        ArrayList<Integer> list = new ArrayList<>();
        int row = 0;
        int col = 0;
        int cur = 1;
        int k = 0;
        for (int i = 0; i < rows+cols-1; i++) {
            list.clear();
            if (i >= cols){
                row = i - cols + 1;
                col = cols-1;
            }
            else {
                row = 0;
                col = i;
            }
            while (row < rows && col >= 0) {
                list.add(matrix[row][col]);
                row++;
                col--;
            }
            if ((cur & 1) == 1) {
                Collections.reverse(list);
            }
            for (int x:list) {
                res[k] = x;
                k++;
            }
            cur++;
        }
        return res;
    }

    public static void main(String[] args) {
        Main498 m = new Main498();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(m.findDiagonalOrder(matrix)));
    }
}
