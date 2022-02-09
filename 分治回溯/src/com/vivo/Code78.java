package com.vivo;

import java.util.ArrayList;
import java.util.List;

public class Code78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backTracking(results, new ArrayList<>(), nums, 0);
        return results;
    }

    public void backTracking(List<List<Integer>> results, List<Integer> tmp, int[] nums, int start) {
        results.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTracking(results, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Code78 code78 = new Code78();
        System.out.println(code78.subsets(nums));
    }
}
