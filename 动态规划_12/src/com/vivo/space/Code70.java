package com.vivo.space;

public class Code70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    public int dp(int n) {
        if (n <= 2) {
            return 1;
        }
        return dp(n - 1) + dp(n - 2);
    }

    public static void main(String[] args) {
        Code70 code70 = new Code70();
        System.out.println(code70.climbStairs(3));
    }
}
