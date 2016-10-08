public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len < 3) {
            return false;
        }
        for (int i = 1; i < len - 1; ++ i) {
            for (int j = i + 1; j <= len; ++ j) {
                String a = num.substring(0, i);
                String b = num.substring(i, j);
                if (search(a, b, num.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(String a, String b, String num) {
        if (a.length() > 1 && a.startsWith("0") || b.length() > 1 && b.startsWith("0")) {
            return false;
        }
        String str = String.valueOf(Long.parseLong(a) + Long.parseLong(b));
        if (num.length() < str.length() || !num.startsWith(str)) {
            return false;
        } else {
            if (num.length() == str.length()) {
                return true;
            } else {
                return search(b, str, num.substring(str.length()));
            }
        }
    }
}
