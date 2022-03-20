package com.vivo.space;

//https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode-solution/
public class Code64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] result = new int[rows][cols];
        result[0][0] = grid[0][0];
        for (int i = 1; i < cols; i++) {
            result[0][i] = result[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < rows; j++) {
            result[j][0] = result[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
            }
        }
        return result[rows - 1][cols - 1];
    }

    public static void main(String[] args){
        Code64 code64=new Code64();
        System.out.println(code64.minPathSum(new int[][]{
                new int[]{1,3,1}, new int[]{1,5,1}, new int[]{4,2,1}
        }));

    }

}
