package com.vivo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode-cn.com/problems/assign-cookies/solution/java-tan-xin-suan-fa-si-lu-qing-xi-dai-m-vf97/
public class Code455 {

    // 这是比较暴力的解法
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            for (int j = g.length - 1; j >= 0; j--) {
                if (s[i] >= g[j]) {
                    result++;
                    g[j] = Integer.MAX_VALUE;
                    break;
                }
            }
        }

        return result;

    }


    // 这个解法就是 利用双指针了 g是小孩 s是饼干
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gindex = 0;
        int sindex = 0;
        int result = 0;

        while (gindex < g.length && sindex < s.length) {
            if (g[gindex] <= s[sindex]) {
                gindex++;
                sindex++;
                result++;
            } else {
                sindex++;
            }
        }


        return result;

    }


    public static void main(String[] args) {
        Code455 code455 = new Code455();
        int r = code455.findContentChildren(new int[]{
                1, 2, 3
        }, new int[]{
                1, 1
        });
        System.out.println(r);
    }
}
