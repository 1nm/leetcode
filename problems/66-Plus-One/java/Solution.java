public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i --) {
            digits[i] += carry;
            if (digits[i] >= 10) {
                digits[i] -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if (carry == 1) {
            int[] newDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newDigits, 0, digits.length);
            newDigits[0] = 1;
            return newDigits;
        } else {
            return digits;
        }
    }
}