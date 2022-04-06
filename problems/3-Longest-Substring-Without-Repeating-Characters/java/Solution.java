public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        int i = 0;
        Map<Character, Integer> lastIndex = new HashMap<>();
        while (i < len) {
            lastIndex.put(s.charAt(i), i);
            int j = i + 1;
            while (j < len && !lastIndex.containsKey(s.charAt(j))) {
                lastIndex.put(s.charAt(j), j);
                j++;
            }
            if (max < j - i) {
                max = j - i;
            }
            if (j == len) {
                break;
            }
            i = lastIndex.remove(s.charAt(j)) + 1;
            lastIndex.clear();
        }
        return max;
    }
}
