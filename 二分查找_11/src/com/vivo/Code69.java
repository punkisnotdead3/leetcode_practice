package com.vivo;

//https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
public class Code69 {
    public int mySqrt(int x) {
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        // 在区间 [left..right] 查找目标元素
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 注意：这里为了避免乘法溢出，改用除法
            if (mid > x / mid) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid..right]
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Code69 code69 = new Code69();
        System.out.println(code69.mySqrt2(8));
    }

    // 这个方法更好理解一点。。
    public int mySqrt2(int x) {
        if (x == 1)
            return 1;
        int left = 0;
        int right = x;
        while (right - left > 1) {
            int mid = (right + left) / 2;
            if (x / mid < mid)
                right = mid;
            else
                left = mid;
        }
        // 取left 很正常 因为 取right 很有可能要超过目标值了
        return left;
    }
}
