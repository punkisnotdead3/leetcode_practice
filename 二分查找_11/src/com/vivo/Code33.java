package com.vivo;

import java.util.Arrays;

//https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/

public class Code33 {
    //将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
    //此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                // left----mid这个区间 是递增的 假设是左边有序
                //  如果target 在这个区间内 则对right进行处理就可以了
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    // 如果target不在这个区间内 则肯定在右边了，要把mid往右边移 则只能left=mid+1
                    left = mid + 1;

                }
            } else {
                // mid---right 这个区间 可能是无序的，也可能是有序的

                //mid-right 这个区间 是有序的
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

