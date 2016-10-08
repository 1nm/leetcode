public class Solution {
    public boolean isScramble(String s1, String s2) {
        int[] count = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; ++ i) {
            count[s1.charAt(i) - 'a'] ++;
            count[s2.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; ++ i)
            if (count[i] != 0) return false;
        if (len <= 1) return true;
        for (int p = 1; p < len; ++ p) {
            if (isScramble(s1.substring(p), s2.substring(p)) && isScramble(s1.substring(0, p), s2.substring(0, p))) return true;
            if (isScramble(s1.substring(0, p), s2.substring(len - p)) && isScramble(s1.substring(p), s2.substring(0, len - p))) return true;
        }
        return false;
    }
}
