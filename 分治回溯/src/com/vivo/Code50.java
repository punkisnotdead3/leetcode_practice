package com.vivo;

/**
 *
 */
public class Code50 {
    public double myPow(double x, int n) {
        // 主要是注意int值的取值范围是  - 2 n次方 到 2的n次方-1 所以 需要用一个long值来保存一下n 否则会发生溢出 其他没有要注意的
        long b = n;
        if (b < 0) {
            return 1.0 / pow(x, -b);
        }
        return pow(x, b);
    }

    public double pow(double x, long n) {
        if (n == 0f) {
            return 1.0f;
        }
        // 这个题比较简单
        double result = pow(x, n / 2);
        if (n % 2L == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }

    public static void main(String[] args) {
        Code50 code50 = new Code50();
        System.out.println(code50.myPow(2, 10));
        System.out.println(code50.myPow(0.00001
                , 2147483647));

    }

}
