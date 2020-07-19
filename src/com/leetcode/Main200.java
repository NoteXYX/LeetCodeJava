package com.leetcode;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 */
public class Main200 {
    public int numIslands(char[][] grid) {
        if (grid== null || grid.length < 1) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    dfs(grid, i, rows, j, cols);
                }
            }
        }
        return res;

    }
    public void dfs(char[][] grid, int row, int rows, int col, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row-1, rows, col, cols);
        dfs(grid, row+1, rows, col, cols);
        dfs(grid, row, rows, col-1, cols);
        dfs(grid, row, rows, col+1, cols);
    }
}
