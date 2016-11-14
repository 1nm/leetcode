public class Solution {
    public int strStr(String haystack, String needle) {
        // return the index of the first occurence of needle in haystack
        // -1 if not found
        // special cases: needle is empty
        // remember to reduce number of comparisions by limiting it to difference of length + 1 times
        if (haystack.length() < needle.length()) return -1;
        if (needle.length() == 0) return 0;
        int s = 0;
        while (s < haystack.length() - needle.length() + 1) {
            int i = s, j = 0;
            while (i < haystack.length() && j < needle.length() && needle.charAt(j) == haystack.charAt(i)) {
                i ++;
                j ++;
            }
            if (j == needle.length()) {
                return s;
            } else {
                s ++;
            }
        }
        return -1;
    }
}
