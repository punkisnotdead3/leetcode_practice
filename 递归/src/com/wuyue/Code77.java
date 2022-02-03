package com.wuyue;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.bilibili.com/video/BV1cy4y127sJ?from=search&seid=4662514939771770726&spm_id_from=333.337.0.0
 *
 * 这里其实 就是看 n=4 ，k=2的场景 是比较好理解的，主要是n=4 k=3的场景  要自己感受下 才能明白 递归的时候 k要k-1
 */
public class Code77 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        com(1, n, k, new ArrayList<>());
        return result;
    }

    public void com(int start, int n, int k, List<Integer> list) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 这里要想明白为啥是 n-k+1 其实这里就是在算 i之后 可以选几个元素， 那必然是n-k+1  因为如果超过这个值，则剩下的不足k位，那么必然是毫无意义的
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            // 这里递归的时候  就要注意了，每次递归的时候 本质上 前进一位是好理解的，但是后面的k-1 不要忘记了， 因为你每走过一步 剩下的自然就少一步
            com(i + 1, n, k - 1, list);
            // 这里要注意的就是 必须要把末尾的去掉 否则 最终的结果集 会多一位 就很尴尬了
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Code77 code = new Code77();
        System.out.println(code.combine(4, 3));
    }
}
