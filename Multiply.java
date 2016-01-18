public class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();
        int[] digits = new int[num1.length() + num2.length()];
        int carry = 0;
        for (int i = 0; i < num1.length(); ++ i) {
            for (int j = 0; j < num2.length(); ++ j) {
                digits[i + j] += (num2.charAt(j) - '0') * (num1.charAt(i) - '0') + carry;
                carry = digits[i + j] / 10;
                digits[i + j] %= 10;
            }
        }
        if (carry != 0) {
            digits[digits.length - 1] = carry;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digits.length; ++ i) {
            sb.append(digits[i]);
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
