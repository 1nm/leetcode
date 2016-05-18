public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        boolean[] replaced = new boolean[sarray.length];
        for (int i = 0; i < sarray.length; i++) {
            if (!replaced[i] && sarray[i] != tarray[i]) {
                // replace all the characters
                for (int j = i; j < sarray.length; j++) {
                    if (sarray[j] == sarray[i]) {
                        sarray[j] = tarray[i];
                        replaced[j] = true;
                    }
                }
            } else if (replaced[i] && sarray[i] != tarray[i]) {
                return false;
            }
        }
        return true;
    }
}
