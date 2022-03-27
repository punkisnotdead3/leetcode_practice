package com.vivo.space;

public class Code213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int res1 = subRob(nums, 0, nums.length - 2);
        int res2 = subRob(nums, 1, nums.length - 1);

        return Math.max(res2, res1);
    }

    public int subRob(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }

    public static void main(String[] args) {
        Code213 code213 = new Code213();
        System.out.println(code213.rob(new int[]{1, 2, 1, 1}));
    }
}
