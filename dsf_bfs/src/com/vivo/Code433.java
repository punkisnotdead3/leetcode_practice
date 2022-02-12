package com.vivo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/solution/bfsqiu-zui-xiao-ji-yin-bian-hua-by-leet-stqq8/
 */
public class Code433 {
    public int minMutation(String start, String end, String[] bank) {
        char[] startArray = start.toCharArray();
        char[] endArray = end.toCharArray();
        List<Integer> diffIndex = new ArrayList<>();
        for (int i = 0; i < startArray.length; i++) {
            if (startArray[i] != endArray[i]) {
                diffIndex.add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(diffIndex.get(0));
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Integer index = queue.poll();

            }
        }
        return -1;


    }

}
