package com.vivo;

import java.util.ArrayList;
import java.util.List;

public class Code22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, 0, "(", n * 2, 1, 0);
        return result;
    }

    public void dfs(List<String> result, int start, String tmp, int length, int leftP, int rightP) {
        if (tmp.length() == length) {
            if (leftP == rightP) {
                result.add(tmp);
            }
            return;
        }
        for (int i = start; i < length; i++) {
            if (rightP > leftP || leftP > length / 2) {
                continue;
            }
            dfs(result, i + 1, tmp + "(", length, leftP + 1, rightP);
            dfs(result, i + 1, tmp + ")", length, leftP, rightP + 1);
            if (tmp.length() > 0) {
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Code22 cc = new Code22();
        System.out.println(cc.generateParenthesis(3));
    }
}
