package com.vivo;

/**
 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 */
public class Code200 {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int row, int col, int maxRows, int maxCols) {
        if (row < 0 || col < 0 || row >= maxRows || col >= maxCols) {
            return;
        }
        if (grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';
        dfs(grid, row + 1, col, maxRows, maxCols);
        dfs(grid, row - 1, col, maxRows, maxCols);
        dfs(grid, row, col + 1, maxRows, maxCols);
        dfs(grid, row, col - 1, maxRows, maxCols);

    }
}
