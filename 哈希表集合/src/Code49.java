import java.util.*;

public class Code49 {
    // 这题主要就是注意一下 最终的结果返回 算法思想很简单， 既然没有重复的字母 那么只要对字母进行排序 那么相等的值就是符合条件的值
    public static List<List<String>>  groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = Arrays.toString(array);
            List<String> value = resultMap.getOrDefault(key, new ArrayList<>());
            value.add(str);
            resultMap.put(key, value);
        }
        return new ArrayList(resultMap.values());
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(str));
    }

}
