public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return result;
        int wordLength = words[0].length();
        int windowLength = words.length * wordLength;
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < words.length; ++ i)
            dict.put(words[i], dict.containsKey(words[i]) ? dict.get(words[i]) + 1 : 1);
        // moving window
        for (int i = 0; i < s.length() - windowLength + 1; ++ i) {
            Map<String, Integer> count = new HashMap<>(dict);
            for (int j = i; j < i + windowLength; j += wordLength) {
                String substr = s.substring(j, j + wordLength);
                if (count.containsKey(substr)) {
                    int c = count.get(substr);
                    if (c == 1)
                        count.remove(substr);
                    else
                        count.put(substr, c - 1);
                }
                else
                    break;
            }
            if (count.isEmpty()) result.add(i);
        }
        return result;
    }
}
