public class Solution {
    public char findTheDifference(String s, String t) {
        int[] c1 = count(s);
        int[] c2 = count(t);
        for (int i = 0; i < 26; ++ i) {
            if (c1[i] != c2[i]) {
                return (char) (i + 'a');
            }
        }
        return ' ';  // should not be reached
    }
    
    private int[] count(String s) {
        int[] ret = new int[26];
        for (int i = 0; i < s.length(); ++ i) {
            ret[s.charAt(i) - 'a']++;
        }
        return ret;
    }
}