package com.company;

public class Code70 {
    /**
     * 这个算法 其实就是 斐波那契数列
     * <p>
     * 爬楼梯 一次性只能爬1个 或者2个， 所以最后一步 要么是爬1个台阶 要么是爬2个台阶
     * <p>
     * 所以问题 分解了以后 就是 f(n)=f(n-1) + f(n-2)
     */
    public int climbStairs(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        if (n > 0) {
            array[1] = 1;
        }
        if (n > 1) {
            array[2] = 2;
        }
        for (int i = 3; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    /**
     *
     *  这个解法 和上述的解法相比 算法思想是一摸一样的 只是代码写的更简洁一些
     */
    public int climbStairs_2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
