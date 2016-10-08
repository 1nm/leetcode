public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int fn2 = 1, fn1 = (isValid(s.charAt(1)) ? 1 : 0) + (isValid(s.charAt(0), s.charAt(1)) ? 1 : 0), fn = 0;
        for (int i = 2; i < s.length(); ++ i) {
            if (isValid(s.charAt(i))) {
                fn += fn1;
            }
            if (isValid(s.charAt(i - 1), s.charAt(i))) {
                fn += fn2;
            }
            if (fn == 0) {
                return 0;
            }
            fn2 = fn1;
            fn1 = fn;
            fn = 0;
        }
        return fn1;
    }
    
    boolean isValid(char a) {
        return a >= '1' && a <= '9';
    }
    
    boolean isValid(char a, char b) {
        return a == '1' && b >= '0' && b <= '9' || a == '2' && b >= '0' && b <= '6';
    }
}