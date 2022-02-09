package com.vivo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code17 {
    // 很开心这道题 还是自己做出来了 虽然方法比较丑陋 效率也不高
    public List<String> letterCombinations(String digits) {
        String[] letterArray = new String[10];
        letterArray[2] = "abc";
        letterArray[3] = "def";
        letterArray[4] = "ghi";
        letterArray[5] = "jkl";
        letterArray[6] = "mno";
        letterArray[7] = "pqrs";
        letterArray[8] = "tuv";
        letterArray[9] = "wxyz";

        char[] charArray = digits.toCharArray();
        List<String> result = new ArrayList<>();
        if (digits.equals("")) {
            return result;
        }
        dfs(letterArray, "", result, charArray, 0);
        return result;
    }

    private void dfs(String[] letterArray, String tmp, List<String> result, char[] charArray, int start) {
        if (tmp.length() == charArray.length) {
            result.add(tmp);
            return;
        }
        for (int i = start; i < charArray.length; i++) {

            char[] c1 = letterArray[Integer.parseInt(charArray[i] + "")].toCharArray();
            for (int j = 0; j < c1.length; j++) {
                tmp = tmp + c1[j];
                dfs(letterArray, tmp, result, charArray, i + 1);
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
    }


    //--------------------------------下面是回溯法中 官方比较好的解------------------------------------------------------------------------------

    public List<String> letterCombinations2(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        // 首先是创建一个map 注意key的类型是 Character
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        // 这里要注意的就是 字符串的拼接可以用stringbuffer
        backtrack2(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack2(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            // step1 取出第一个 数字
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            // 每个数组 对应一组字母 然后遍历这些字母
            for (int i = 0; i < lettersCount; i++) {
                // 加入到结果中
                combination.append(letters.charAt(i));
                // 递归，注意index要加1了 因为要取后面的数字了
                backtrack2(combinations, phoneMap, digits, index + 1, combination);
               // System.out.println(combination);
                // 这一行千万不能漏，因为你选完了以后  如果不删除你刚选的 那么就会出现 ad, ade, adef, adefbd, adefbde, adefbdef 这种情况
                combination.deleteCharAt(index);
            }
        }
    }





    public static void main(String[] args) {
        Code17 code17 = new Code17();
//        System.out.println(code17.letterCombinations("23"));
        System.out.println(code17.letterCombinations2("23"));

    }

}
