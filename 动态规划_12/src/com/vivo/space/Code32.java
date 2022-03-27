package com.vivo.space;

import java.util.Stack;

//https://www.bilibili.com/video/BV1VE411t75D?spm_id_from=333.337.search-card.all.click
public class Code32 {
    public int longestValidParentheses(String s) {
        int length = s.length();
        // 长度+1 免的要考虑-1的情况
        int[] dp = new int[length + 1];
        int max = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            int index = i + 1;
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    // 其实不用push
                    //stack.push(')');
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                        int value = 1 + dp[index - 1];
                        int prev = index - value * 2;
                        if (dp[prev] > 0) {
                            value += dp[prev];
                        }
                        dp[index] = value;
                        max = Math.max(max, value);
                    } else {
                        //stack.push(')');
                    }
                }
            }
        }
        return max * 2;
    }

    public static void main(String[] args) {
        Code32 code32 = new Code32();
        System.out.println(code32.longestValidParentheses(")()())"));
    }
}
