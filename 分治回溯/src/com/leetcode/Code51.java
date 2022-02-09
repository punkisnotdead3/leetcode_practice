package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/solution/n-huang-hou-java-by-sui-ji-guo-cheng-sui-q0ot/
 */
public class Code51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] array : chessboard) {
            Arrays.fill(array, '.');
        }
        List<List<String>> result = new ArrayList<>();
        dfs(chessboard, result, 0);
        return result;
    }

    public void dfs(char[][] chessboard, List<List<String>> result, int row) {
        if (row == chessboard.length ) {
            result.add(getChessboardResult(chessboard));
            return;
        }
        int length = chessboard[row].length;
        for (int i = 0; i < length; i++) {
            if (!isValid(chessboard, row, i)) {
                continue;
            }
            chessboard[row][i] = 'Q';
            dfs(chessboard, result, row + 1);
            chessboard[row][i] = '.';
        }

    }

    public boolean isValid(char[][] chessboard, int row, int col) {
        if (row - 1 < 0) {
            return true;
        }
        // 这个棋子的上面 有没有Q
        for (int i = row - 1; i >= 0; i--) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        int leftRow = row;
        // 这个棋子的左上面 有没有Q
        for (int j = col - 1; j >= 0; j--) {
            leftRow--;
            if (leftRow < 0) {
                break;
            }
            if (chessboard[leftRow][j] == 'Q') {
                return false;
            }
        }

        int rightRow = row;
        // 这个棋子的右上面 有没有Q
        for (int k = col + 1; k < chessboard.length ; k++) {
            rightRow--;
            if (rightRow < 0) {
                break;
            }
            if (chessboard[rightRow][k] == 'Q') {
                return false;
            }
        }
        return true;
    }


    public List<String> getChessboardResult(char[][] chessboard) {
        List<String> result = new ArrayList<>();
        for (char[] array : chessboard) {
            result.add(String.copyValueOf(array));
        }
        return result;
    }

    public static void main(String[] args) {
        Code51 code51 = new Code51();
        System.out.println(code51.solveNQueens(4));
    }
}