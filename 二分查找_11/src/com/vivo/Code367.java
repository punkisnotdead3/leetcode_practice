package com.vivo;

//https://leetcode-cn.com/problems/valid-perfect-square/solution/wei-rao-li-lun-mian-shi-huan-shi-er-fen-e5txo/
public class Code367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long  left = 1;
        long  right = num / 2;
        while (left < right) {
            long  mid = (left + right) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else if (mid * mid > num) {
                right = mid - 1;
            }

        }
        if (left * left == num) return true;
        return false;
    }

    public static void main(String[] args) {
        Code367 code367 = new Code367();
        System.out.println(code367.isPerfectSquare(9));
    }
}
