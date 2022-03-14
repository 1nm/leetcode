public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; ++ i) {
            result = count(result);
        }
        return result;
    }
    
    private String count(String s) {
        String result = "";
        int i = 0;
        while (i < s.length()) {
            char curr = s.charAt(i);
            int j = 1;
            while (i + j < s.length() && s.charAt(i + j) == curr) {
                j ++;
            }
            result += String.valueOf(j);
            result += curr;
            i += j;
        }
        return result;
    }
}