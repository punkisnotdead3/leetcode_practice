package com.wuyue;

import java.util.HashMap;
import java.util.Map;

// 这个问题 有多种解法 这里用递归
public class Code70 {
    // 这种解法 好理解 但是 会超时
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    // 下面这个虽然也是递归，但是 会缓存 计算过的值，所以效率上会比上面的递归要高出不少

    private Map<Integer, Integer> result = new HashMap<>();

    public int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int n1 = result.getOrDefault(n - 1, 0);
        int n2 = result.getOrDefault(n - 2, 0);
        if (n1 == 0) {
            n1 = climbStairs2(n - 1);
            result.put(n - 1, n1);
        }
        if (n2 == 0) {
            n2 = climbStairs2(n - 2);
            result.put(n - 2, n2);
        }


        return n1 + n2;
    }
}
