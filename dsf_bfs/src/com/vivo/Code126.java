package com.vivo;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-3/
 */
public class Code126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        // 主要是这里要理解好
        Set<String> allvisited = new HashSet<>();
        path.add(beginWord);
        queue.offer(path);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isFound = false;
            Set<String> visited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> cur = queue.poll();
                String lastWord = cur.get(cur.size() - 1);
                List<String> nextWords = getNextWords(lastWord, wordSet);
                for (int j = 0; j < nextWords.size(); j++) {
                    if (!allvisited.contains(nextWords.get(j))) {
                        // 如果找到了
                        if (nextWords.get(j).equals(endWord)) {
                            isFound = true;
                            cur.add(endWord);
                            result.add(new ArrayList<>(cur));
                            // 这里千万不要遗漏删除最后一步
                            cur.remove(cur.size() - 1);
                            break;
                        }
                        cur.add(nextWords.get(j));
                        visited.add(nextWords.get(j));
                        queue.offer(new ArrayList<>(cur));
                        cur.remove(cur.size() - 1);
                    }
                }
            }
            if (isFound) {
                return result;
            } else {
                allvisited.addAll(visited);
            }
        }
        return result;
    }

    public List<String> getNextWords(String beginWord, Set<String> wordSet) {
        char[] beginArray = beginWord.toCharArray();
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < beginArray.length; i++) {
            char source = beginArray[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == source) {
                    continue;
                }
                beginArray[i] = j;
                String next = new String(beginArray);
                if (wordSet.contains(next)) {
                    nextWords.add(next);
                }
            }
            beginArray[i] = source;
        }
        return nextWords;
    }

}
