package com.company;


class Solution {
    /**
     * 算法说明：
     * 1. i 和j 一开始都指向数组的头部
     * 2. 每次循环 i 都是固定向右挪动一个位置
     * 3. 每次循环的时候 判断一下如果 位置i的值不等于0 那么就把位置j的值
     * 设置成位置i的值，并且j++
     * 4. 一直循环到i到数组最后一个位置 第一遍循环就结束了
     * 5. 此时 不等于0的元素 也就都被挪到了左边。从j开始就都是0的元素了
     * 6. 第二遍循环从j开始 就是把所有的元素都设置成0了
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 算法说明
     * 1. 定义2个指针，left指针和right指针都指向 数组的头部
     * 2. right 指针固定都是向右走 每次都走，left指针则不一定
     * 3. for循环数组， 当发现 right位置的元素不等于0的时候
     *    就和left位置的元素 互相交换值，并且交换完以后 left++
     *
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        int leftPointer = 0;
        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
            if (nums[rightPointer] != 0) {
                int k = nums[rightPointer];
                nums[rightPointer] = nums[leftPointer];
                nums[leftPointer] = k;
                leftPointer++;
            }
        }
    }
}