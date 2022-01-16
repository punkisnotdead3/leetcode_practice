import java.util.HashMap;
import java.util.Map;

public class Code242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.getOrDefault(c, 0) < 0) {
                return false;
            }
        }
        return true;
    }
}
