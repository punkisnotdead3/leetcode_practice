package com.vivo.space;

//https://www.bilibili.com/video/BV1h4411A7go?spm_id_from=333.337.search-card.all.click
public class Code221 {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int res = 0;
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] != '0') {
                dp[0][i] = 1;
                res = 1;
            }
        }

        for (int j = 0; j < rows; j++) {
            if (matrix[j][0] != '0') {
                dp[j][0] = 1;
                res = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != '0') {
                    int temp = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                    dp[i][j] = temp;
                    res = Math.max(res, temp);
                }
            }
        }
        return res * res;
    }
}
