public class Solution {
    public int getSum(int a, int b) {
        return sum(a, b);
    }
    
    int sum(int a, int b) {
        return b == 0 ? a : sum(a ^ b, (a & b) << 1);
    }
    
    int sub(int a, int b) {
        return b == 0 ? a : sum(a ^ b, (~a & b) << 1);
    }
}