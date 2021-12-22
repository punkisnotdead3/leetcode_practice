package com.company;

public class Code189 {
    /**
     * 算法的核心思路 就是：
     * 1 先把整个数组 反转 reverse
     * 2 按照k来分割整个数组， 分别reverse 就可以了
     *
     * 这里最不该遗漏的就是  k %= nums.length
     *
     * 假设k的值 比num.length 还要大的话 其实就是挪动 k和length 取余就行了
     *
     *
     *
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums,int start,int end){
        while (start<end){
            int tmp=nums[end];
            nums[end]=nums[start];
            nums[start]=tmp;
            start++;
            end--;
        }
    }
}
