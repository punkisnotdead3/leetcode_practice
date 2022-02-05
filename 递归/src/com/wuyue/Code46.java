package com.wuyue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  https://www.bilibili.com/video/BV1up4y1s7yB?from=search&seid=18325169954029188086&spm_id_from=333.337.0.0
 */
public class Code46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            visited.put(nums[i], false);
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
            if (!visited.getOrDefault(nums[i],false)) {
                tmp.add(nums[i]);
                visited.put(nums[i], true);
                backTracking(nums, tmp, result, visited);
                // 重点是在这里， backTracking 结束递归的时候 意味着  没有找到合适的元素 或者是 已经add result里面了，那自然要 把tmp的元素清理掉，方便后面继续 进行递归
                tmp.remove(tmp.size()-1);
                visited.put(nums[i],false);
            }
        }

    }

    public static void main(String[] args) {
        Code46 code = new Code46();
        int[] nums = {1, 2,3};
        System.out.println(code.permute(nums));
    }
}
