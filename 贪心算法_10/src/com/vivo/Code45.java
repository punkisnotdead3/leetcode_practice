package com.vivo;

//https://leetcode-cn.com/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
//https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
public class Code45 {
    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int length = nums.length;
        int maxReach = 0;
        for (int i = 0; i < length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == end) {
                end = maxReach;
                step++;
            }
        }
        return step;
    }
}
