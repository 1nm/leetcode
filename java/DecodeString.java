public class Solution {

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public String decodeString(String s) {
        Stack<Integer> repeats = new Stack<>();
        Stack<StringBuilder> sbs = new Stack<>();
        int i = 0, r = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (isDigit(s.charAt(i))) { // push repeat
                repeats.push(r);
                r = 0;
                while (i < s.length() && isDigit(s.charAt(i))) {
                    r = r * 10 + (int) (s.charAt(i) - '0');
                    i++;
                }
                i --;
            } else if (s.charAt(i) == '[') { // push sb
                sbs.push(sb);
                sb = new StringBuilder();
            } else if (s.charAt(i) == ']') { // pop stack and do the repeat
                String str = sb.toString();
                for (int j = 0; j < r - 1; ++ j) {
                    sb.append(str);
                }
                sb = sbs.pop().append(sb.toString());
                r = repeats.pop();
            } else {
                sb.append(s.charAt(i));
            }
            i ++;
        }
        return sb.toString();
    }
}