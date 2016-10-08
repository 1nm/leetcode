public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < sarray.length; i++) {
            if (!map.containsKey(sarray[i])) {
                if (map.containsValue(tarray[i])) {
                    return false;
                }
                map.put(sarray[i], tarray[i]);
            } else if (map.get(sarray[i]) != tarray[i]) {
                return false;
            }
        }
        return true;
    }
}
