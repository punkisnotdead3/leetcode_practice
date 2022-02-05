package com.wuyue;

import java.util.*;

/**
 * https://www.bilibili.com/video/BV11T4y1c7ch?from=search&seid=1757308794677706390&spm_id_from=333.337.0.0
 */
public class Code47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            visited.put(i, false);
        }
        backTracking(nums, new ArrayList<>(), result, visited);

        return result;
    }

    public void backTracking(int[] nums, List<Integer> tmp, List<List<Integer>> result, Map<Integer, Boolean> visited) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1] && !visited.getOrDefault(i - 1, false)) {
                continue;
            }

            if (!visited.getOrDefault(i, false)) {
                tmp.add(nums[i]);
                visited.put(i, true);
                backTracking(nums, tmp, result, visited);
                // 重点是在这里， backTracking 结束递归的时候 意味着  没有找到合适的元素 或者是 已经add result里面了，那自然要 把tmp的元素清理掉，方便后面继续 进行递归
                tmp.remove(tmp.size() - 1);
                visited.put(i, false);
            }
        }

    }


    public static void main(String[] args) {
        Code47 code = new Code47();
        int[] nums = {1, 1, 2};
        System.out.println(code.permuteUnique(nums));
    }
}
