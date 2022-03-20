package com.vivo.space;


//https://www.bilibili.com/video/BV1qf4y1i7Mx?spm_id_from=333.337.search-card.all.click
public class Code198 {
    public int rob(int[] nums) {
        // dp(n)=max(dp(n-1),dp(n-2)+nums[n])
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
