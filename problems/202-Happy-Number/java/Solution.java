public class Solution {
    
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (!set.contains(n)) {
            set.add(n);
            n = getNext(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
    
    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}