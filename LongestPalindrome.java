public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[52];
        for (int i = 0; i < s.length(); ++ i) {
            char c = s.charAt(i);
            if (c >= 'A' && c <='Z') { // upper case
                count[c - 'A'] ++;
            } else { // lower case
                count[c - 'a' + 26] ++;
            }
        }

        int max = 0; boolean hasOdd = false;
        for (int i = 0; i < 52; ++ i) {
            if (count[i] % 2 == 1) hasOdd = true;
            max += (count[i] / 2) * 2;
        }
        return hasOdd ? max + 1 : max;
    }
}
