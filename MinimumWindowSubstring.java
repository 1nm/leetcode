public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        int min = Integer.MAX_VALUE;
        String result = "";

        int[] countS = new int[256];
        int[] countT = new int[256];
        for (int i = 0; i < t.length(); ++ i)
            countT[(int) t.charAt(i)] ++;

        int start = 0, end = 0;

        while (end < s.length()) {
            while (end < s.length() && !included(countS, countT)) {
                countS[(int) s.charAt(end++)] ++;
            }
            if (end == s.length() && !included(countS, countT)) break;
            while (start < end && included(countS, countT)) {
                countS[(int) s.charAt(start++)] --;
            }
            if (min > end - start + 1) {
                min = end - start + 1;
                result = s.substring(start - 1, end);
            }
        }

        return result;
    }

    private boolean included(int[] countS, int[] countT) {
        for (int i = 0; i < countS.length; ++ i)
            if (countS[i] < countT[i])
                return false;
        return true;
    }
}
