package com.vivo.space;

//https://leetcode-cn.com/problems/maximum-product-subarray/solution/dpfang-fa-xiang-jie-by-yang-cong-12/
public class Code152 {
    public int maxProduct(int[] nums) {
        // 主要是要考虑负数的情况，  因为 负数乘以负数 可能是正数，所以之前的最大值有可能乘以一个负数就变成最小值了
        // 之前的最小值 乘以一个负数 有可能就是最大值了
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 要跟自己比较 是因为 有可能出现0的情况
            maxDp[i] = Math.max(nums[i], Math.max(minDp[i - 1] * nums[i], nums[i] * maxDp[i - 1]));
            minDp[i] = Math.min(nums[i], Math.min(minDp[i - 1] * nums[i], nums[i] * maxDp[i - 1]));
            res = Math.max(res, maxDp[i]);
        }

        return res;

    }

    public static void main(String[] args) {
        Code152 code152 = new Code152();
        System.out.println(code152.maxProduct(new int[]{2, 3, -2, 4}));
    }
}
