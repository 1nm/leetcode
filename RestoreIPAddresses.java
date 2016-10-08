public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtracking(result, new LinkedList<String>(), s, 0);
        return result;
    }

    private boolean isValidIPV4(String num) {
        if (num.length() == 0 || num.length() > 3 || (num.length() > 1 && num.startsWith("0"))) {
            return false;
        }
        int n = Integer.parseInt(num);
        return (n >= 0 && n <= 255);
    }

    private void backtracking(List<String> result, LinkedList<String> ip, String s, int from) {
        if (ip.size() == 4) {
            if (from == s.length()) {
                StringBuffer sb = new StringBuffer();
                for (String num : ip) {
                    if (sb.length() > 0) {
                        sb.append('.');
                    }
                    sb.append(num);
                }
                result.add(sb.toString());
            }
            return;
        }
        for (int i = 1; i <= 3 && from + i <= s.length(); ++ i) {
            String num = s.substring(from, from + i);
            if (isValidIPV4(num)) {
                ip.add(num);
                backtracking(result, ip, s, from + i);
                ip.removeLast();
            }
        }
    }
}
