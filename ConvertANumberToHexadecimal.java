public class Solution {
    public String toHex(int num) {
        return toHex((long) num);
    }

    private String toHex(long num) {
        if (num == 0) return "0";
        if (num < 0) return toHex(num + (1L << 32));
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int r = (int) (num % 16);
            sb.insert(0, r < 10 ? (char) ('0' + r) : (char) ('a' + (r - 10)));
            num /= 16;
        }
        return sb.toString();
    }
}
