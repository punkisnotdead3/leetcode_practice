package com.vivo;

//https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
public class Code55 {
    public boolean canJump(int[] nums) {
        int reach = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (reach < i) {
                return false;
            }
            reach = Math.max(i + nums[i], reach);

        }
        return true;
    }
}
