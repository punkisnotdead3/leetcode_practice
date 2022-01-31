package com.wuyue;

import java.util.ArrayList;
import java.util.List;

/**
 * 这道题 主要想明白 其实就是把 括号 放到2*n 个位置里面
 *
 * 所谓的成对出现  其实就是 左括号不能比右括号多 ，且个数不能大于n
 *
 * 先放 左括号 即可
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class Code22 {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        gen(0, 0, "", n);
        return result;
    }

    public void gen(int left, int right, String s, int max) {
        if (right > left || left > max) {
            return;
        }
        if (s.length() == max * 2) {
            result.add(s);
            return;
        }
        gen(left + 1, right, s + "(", max);
        gen(left, right + 1, s + ")", max);
    }

    public static void main(String[] args) {
        Code22 code22 = new Code22();
        System.out.println(code22.generateParenthesis(3));
    }
}
