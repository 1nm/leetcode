public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder expr, String num, int target, int pos, long total, long multi) {
        if (pos == num.length() && (total == (long) target)) {
            result.add(expr.toString());
            return;
        }
        for (int end = pos + 1; end <= num.length(); ++ end) {
            String str = num.substring(pos, end);
            if (str.length() > 1 && str.charAt(0) == '0') break;
            long val = Long.parseLong(str);
            int len = expr.length();
            if (pos == 0) {
                backtrack(result, expr.append(str), num, target, end, val, val);
                expr.setLength(len);
            } else {
                backtrack(result, expr.append('+').append(str), num, target, end, total + val, val);
                expr.setLength(len);
                backtrack(result, expr.append('-').append(str), num, target, end, total - val, -val);
                expr.setLength(len);
                backtrack(result, expr.append('*').append(str), num, target, end, total - multi + multi * val, multi * val);
                expr.setLength(len);
            }
        }
    }
}
