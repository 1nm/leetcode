public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            sum = (i >= 0 ? (num1.charAt(i) - '0') : 0) + (j >= 0 ? (num2.charAt(j) - '0') : 0) + carry;
            carry = sum / 10;
            sum %= 10;
            sb.insert(0, String.valueOf(sum));
            i --;
            j --;
        }
        if (carry != 0)
            sb.insert(0, String.valueOf(carry));
        return sb.toString();
    }
}
