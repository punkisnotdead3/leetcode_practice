package com.vivo.space;

//https://www.bilibili.com/video/BV1nv411P7bk?spm_id_from=333.337.search-card.all.click
public class Code121 {
    /**
     * 这道题动态规划其实 就是
     * 假设你在 第n天卖出， 那么最大收益其实就是 n-1 这些天中 价格最低的那个
     * 所以 用res 来记录 第1天 第2天 第三天 第n天 中最大的结果值
     * 同时还要用一个min值 来记录 前面这n-1天 中最便宜的那个价格
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return res;

    }
}
