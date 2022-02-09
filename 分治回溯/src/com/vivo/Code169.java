package com.vivo;

import java.util.Arrays;

public class Code169 {

    // 这个题目挺有意思的，既然是出现次数大于n/2 的 数字，那么排序之后 中间的元素 一定是这个树
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {

    }
}
