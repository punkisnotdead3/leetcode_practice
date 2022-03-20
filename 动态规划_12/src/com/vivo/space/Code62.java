package com.vivo.space;

//https://www.bilibili.com/video/BV1zp4y1i7Zz
public class Code62 {
    public int uniquePaths(int m, int n) {
        //m 代表有多少行 n 代表有多少列
        // 二位数组总是 第一个参数代表行 第二个参数代表列
        int[][] array = new int[m][n];
        // 第一列都是1
        for (int i = 0; i < n; i++) {
            array[0][i] = 1;
        }
        // 第一行也是1
        for (int j = 0; j < m; j++) {
            array[j][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m-1][n-1];
    }
}
