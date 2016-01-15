public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len < 3) {
            return false;
        }
        for (int i = 1; i < len - 1; ++ i) {
            for (int j = i + 1; j <= len; ++ j) {
                long a = Long.parseLong(num.substring(0, i));
                long b = Long.parseLong(num.substring(i, j));
                if (search(a, b, num.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(long a, long b, String num) {
        a += b;
        String str = String.valueOf(a);
        if (num.length() < str.length() || !num.startsWith(str)) {
            return false;
        } else {
            if (num.length() == str.length()) {
                return true;
            } else {
                return search(b, a, num.substring(str.length()));
            }
        }
    }
}
