public class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        } else {
            int root = num % 9;
            return root == 0 ? 9 : root;
        }
    }
}