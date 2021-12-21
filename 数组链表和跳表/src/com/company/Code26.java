package com.company;

public class Code26 {
    /**
     *  还是双指针的解法
     *
     *  因为数组是排序好的
     *
     *  所以相等的元素 必然是相邻的元素
     *
     *  slow 和 quick 不等的话 就把quick的元素 赋值给slow+1 的位置就可以了
     *
     *
     */
    public int removeDuplicates(int[] nums) {

        int slow = 0;
        int quick = 1;
        while (quick < nums.length) {
            if (nums[slow] != nums[quick]) {
                nums[++slow] = nums[quick];
            }
            quick++;
        }
        return  slow+1;
    }
}
