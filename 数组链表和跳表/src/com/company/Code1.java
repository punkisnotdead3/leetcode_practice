package com.company;

import java.util.HashMap;
import java.util.Map;

public class Code1 {
    /**
     *  算法思想：
     *  首先定义一个map。这个map的key 就是数值，value就是数值对应的数组下标
     *
     *  假设target为9 遍历到一个数值是3
     *
     *  那么就去map里面找有没有6的这个数字即可 有就直接返回结果
     *
     *  没有就把3和3对应的下标 put 到map中即可
     *
     *
     */
    public int[] twoSum(int[] nums, int target) {
        // key 是数值 value 是数组下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{
                        map.get(target - nums[i]), i
                };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
