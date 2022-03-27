package com.vivo.space;

import sun.lwawt.macosx.CPlatformEmbeddedFrame;

//https://leetcode-cn.com/problems/decode-ways/solution/jie-ma-fang-fa-tu-jie-dp-zui-qing-xi-yi-97hng/
public class Code91 {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int cInt = c - '0';

            char pre = s.charAt(i - 1);
            int preInt = pre - '0';

            int doubleCharInt = preInt * 10 + cInt;

            if (i == 1) {

                if (cInt == 0) {
                    if (preInt > 2) {
                        dp[1] = 0;
                        continue;
                    }
                    dp[1] = 1;
                    continue;
                }
                if (doubleCharInt > 10 && doubleCharInt <= 26) {
                    dp[1] = 2;
                    continue;
                }
            }

            if (cInt >= 1 && cInt <= 9) {
                dp[i] = dp[i - 1];
            }
            if (i >= 2) {
                if (doubleCharInt >= 10 && doubleCharInt <= 26) {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }


        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        Code91 code91 = new Code91();
        System.out.println(code91.numDecodings("12"));
        System.out.println(code91.numDecodings("226"));
        System.out.println(code91.numDecodings("0"));
        System.out.println(code91.numDecodings("2101"));
        System.out.println(code91.numDecodings("301"));

    }
}
