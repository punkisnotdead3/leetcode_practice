package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code15 {
    /**
     *
     * 这里算法 是先把 给定的数组从小到大排序
     *
     * 然后 for循环
     * 左边k 是固定的，每次k+1 即可
     *
     * i 就是k+1的位置 j 就是固定在数组的尾部
     * 
     * 计算 nums k i j 的和
     *
     * <0 自然就往右移动i  否则 往左边移动j
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 从小到达排列
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        // 注意这里是lenght-2
        for (int k = 0; k < nums.length - 2; k++) {
            // 从小到大排列的 所以 头部的值大于0 后面显然不可能等于0了 直接跳出
            if (nums[k] > 0) return resultList;
            // 重复元素没必要判断
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int leftPointer = k + 1;
            int rightPointer = nums.length - 1;
            while (leftPointer < rightPointer) {
                int sum = nums[k] + nums[leftPointer] + nums[rightPointer];
                if (sum > 0) {
                    // 有重复元素的话 直接跳过 这里就是防止有重复元素 注意是 --P 或者++p 别写错了
                    while (leftPointer < rightPointer && nums[rightPointer] == nums[--rightPointer]) ;
                } else if (sum < 0) {
                    // 有重复元素的话 直接跳过
                    while (leftPointer < rightPointer && nums[leftPointer] == nums[++leftPointer]) ;
                } else {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[k]);
                    result.add(nums[leftPointer]);
                    result.add(nums[rightPointer]);
                    resultList.add(result);
                    // 这里不要遗漏了，找到一个解以后 不要遗漏 可以继续找其他解
                    while (leftPointer < rightPointer && nums[rightPointer] == nums[--rightPointer]) ;
                    while (leftPointer < rightPointer && nums[leftPointer] == nums[++leftPointer]) ;

                }

            }
        }
        return resultList;
    }
}
