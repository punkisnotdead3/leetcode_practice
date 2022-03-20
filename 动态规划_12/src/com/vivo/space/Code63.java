package com.vivo.space;

//https://www.bilibili.com/video/BV1gz4y1Q7Yu?spm_id_from=333.337.search-card.all.click
public class Code63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < cols; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int j = 0; j < rows; j++) {
            if (obstacleGrid[j][0] == 1) {
                break;
            }
            dp[j][0] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
