public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return result;
        int wordLength = words[0].length();
        int windowLength = words.length * wordLength;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; ++ i)
            set.add(words[i]);
        boolean[] match = new boolean[s.length()];
        for (int i = 0; i < s.length() - wordLength; ++ i)
            if (set.contains(s.substring(i, i + wordLength)))
                match[i] = true;
        // moving window
        for (int i = 0; i < s.length() - len; ++ i) {
            boolean found = true;
            for (int j = i; j < i + windowLength; j += wordLength) {
                if (!match[j]) {
                    found = false;
                    break;
                }
            }
            if (found) result.add(i);
        }
        return result;
    }
}
