public class Solution {
    Set<Integer> happy = new HashSet<Integer>();
    Set<Integer> unhappy = new HashSet<Integer>();
    Set<Integer> unknown = new HashSet<Integer>();
    
    public boolean isHappy(int n) {
        
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
