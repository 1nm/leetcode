public class Solution {
    public String getPermutation(int n, int k) {
        k = k - 1;
        int[] factorial = new int[10];
        Arrays.fill(factorial, 1);
        for (int i = 2; i < 10; ++ i) {
            factorial[i] = i * factorial[i - 1];
        }
        StringBuffer nums = new StringBuffer("123456789".substring(0, n));
        StringBuffer sb = new StringBuffer();
        for (int i = n; i >= 1; -- i) {
            int chozen = k / factorial[i - 1];
            k %= factorial[i - 1];
            sb.append(nums.charAt(chozen));
            nums.deleteCharAt(chozen);
        }
        return sb.toString();
    }
}