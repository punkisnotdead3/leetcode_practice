package com.vivo.space;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/solution/xiang-xi-jie-du-dong-tai-gui-hua-de-shi-xian-yi-li/
 */
public class Code53 {
    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int max_ending_hear = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_ending_hear = Math.max(max_ending_hear + nums[i], nums[i]);
            max_so_far = Math.max(max_so_far, max_ending_hear);
        }
        return max_so_far;
    }
}
