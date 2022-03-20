package com.vivo.space;

import java.util.Arrays;

//https://mp.weixin.qq.com/s/ZhPEchewfc03xWv9VP3msg
public class Code1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // 创建这个数组 只是为了加一个结果缓存
        int[][] array = new int[m][n];
        for (int[] a : array) {
            Arrays.fill(a, -1);
        }
        return dp(text1, 0, text2, 0, array);
    }

    public int dp(String text1, int i, String text2, int j, int[][] array) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (array[i][j] != -1) {
            return array[i][j];
        }

        //只要字母相等 那么必然在最终的结果中
        if (text1.charAt(i) == text2.charAt(j)) {
            array[i][j] = 1 + dp(text1, i + 1, text2, j + 1, array);
        } else {
            // 如果不相等 就是 往后移 找到相等的再说 要么是text1 后移 要么是text2 后移动
            array[i][j] = Math.max(dp(text1, i + 1, text2, j, array), dp(text1, i, text2, j + 1, array));
        }
        return array[i][j];
    }
}
