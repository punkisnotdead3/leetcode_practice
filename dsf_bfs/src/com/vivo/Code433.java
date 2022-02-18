package com.vivo;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/solution/bfsqiu-zui-xiao-ji-yin-bian-hua-by-leet-stqq8/
 */
public class Code433 {
    public int minMutation(String start, String end, String[] bank) {
        HashMap<String, Character[]> map = new HashMap<>();
        map.put("A", new Character[]{'C', 'G', 'T'});
        map.put("C", new Character[]{'A', 'G', 'T'});
        map.put("G", new Character[]{'C', 'A', 'T'});
        map.put("T", new Character[]{'C', 'G', 'A'});

        Set<String> bankSet = new HashSet<>(Arrays.asList((bank)));

        if (!bankSet.contains(end)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                List<String> nextString = new ArrayList<>(getResult(cur, map));
                for (int j = 0; j < nextString.size(); j++) {
                    if (bankSet.contains(nextString.get(j))) {
                        if (nextString.get(j).equals(end)) {
                            step++;
                            return step;
                        } else {
                            queue.offer(nextString.get(j));
                        }
                    }
                }

            }
            step++;
        }
        return -1;
    }

    public Set<String> getResult(String begin, HashMap<String, Character[]> map) {
        Set<String> result = new HashSet<>();
        char[] source = begin.toCharArray();
        for (int i = 0; i < source.length; i++) {
            char s1 = source[i];
            Character[] sarray = map.get(s1 + "");
            for (int j = 0; j < sarray.length; j++) {
                source[i] = sarray[j];
                result.add(new String(source));
            }
            source[i] = s1;
        }

        return result;
    }

    public static void main(String[] args) {
        Code433 code433 = new Code433();
//        System.out.println(code433.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));

//        "AACCTTGG"
//        "AATTCCGG"
//                ["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]
        System.out.println(code433.minMutation("AACCTTGG", "AATTCCGG", new String[]{"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"}));

    }

}
