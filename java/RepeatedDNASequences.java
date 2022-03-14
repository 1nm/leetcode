public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> hash = new HashSet<String>();
        Set<String> result = new HashSet<String>();
        int length = s.length();
        for (int i = 0; i < length - 9; ++ i) {
            String substr = s.substring(i, i + 10);
            if (hash.contains(substr)) {
                result.add(substr);
            } else {
                hash.add(substr);
            }
        }
        return new ArrayList<String>(result);
    }
}