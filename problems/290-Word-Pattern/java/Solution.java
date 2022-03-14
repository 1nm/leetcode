public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!strs[i].equals(map.get(c))) {
                    return false;
                }
            } else {
                if (map.containsValue(strs[i])) {
                    return false;
                }
                map.put(c, strs[i]);
            }
        }
        return true;
    }
}