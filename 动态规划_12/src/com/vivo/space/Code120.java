package com.vivo.space;

import java.util.ArrayList;
import java.util.List;

public class Code120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size + 1][size + 1];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        Code120 code120 = new Code120();
        List<Integer> list0 = new ArrayList<>();
        list0.add(2);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list0);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);

        System.out.println(code120.minimumTotal(triangle));
    }
}
