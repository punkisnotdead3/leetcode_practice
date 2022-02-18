package com.vivo;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you-2/
 */
public class Code127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 可用的字典放到set中
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String begin = queue.poll();
                if (check(wordSet, visited, begin, endWord, queue)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    public boolean check(Set<String> wordSet, Set<String> visited, String begin, String end, Queue<String> queue) {
        char[] beginArray = begin.toCharArray();
        for (int i = 0; i < beginArray.length; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                char origin = beginArray[i];
                beginArray[i] = j;
                String changed = new String(beginArray);
                // 如果修改后的字符串 在 字典set里面
                if (wordSet.contains(changed)) {
                    // 先判断 修改后的字符串是不是最终字符串 如果是的话 就直接返回true 代表已经查到了
                    if (changed.equals(end)) {
                        return true;
                    }
                    // 如果不是最终的字符串 则要加到路径里，这一步很重要 就是防止回头路
                    if (!visited.contains(changed)) {
                        visited.add(changed);
                        queue.offer(changed);
                    }
                }
                // 不要忘记 在设置回去
                beginArray[i] = origin;
            }
        }
        return false;
    }
}
