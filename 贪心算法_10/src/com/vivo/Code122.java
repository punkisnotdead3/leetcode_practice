package com.vivo;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/best-time-to-buy-and-sell-stock-ii-zhuan-hua-fa-ji/
public class Code122 {
    // 连续上涨的交易日 则是 第一天买最后一天卖 和每天都买卖 其实利润是一样的 仔细看题解有解释
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                result = result + prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}
