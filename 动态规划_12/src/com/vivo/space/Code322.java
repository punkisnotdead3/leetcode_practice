package com.vivo.space;

import java.util.Arrays;

public class Code322 {

    /**
     * 1,2,5 让你凑出来11
     * <p>
     * 要想有11的解 其实就是  要有 10 9 6 的解， 因为 最后一个硬币 只可能是1，2，5
     * <p>
     * 那么以此类推 就是一个二叉树
     * <p>
     * 节点最少的那个 就是最终的 最优解了
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] array = new int[amount + 1];
        Arrays.fill(array, Integer.MIN_VALUE);
        return subCoinChange(coins, amount, array);

    }

    public int subCoinChange(int[] coins, int amount, int[] array) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (array[amount] != Integer.MIN_VALUE) {
            return array[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // for循环中 套用递归
            int subResult = subCoinChange(coins, amount - coin, array);
            if (subResult == -1) continue;
            res = Math.min(res, subResult + 1);
        }

        array[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return array[amount];
    }

    public static void main(String[] args) {
        Code322 c = new Code322();
        System.out.println(c.coinChange(new int[]{1, 2, 5}, 11));
    }
}
