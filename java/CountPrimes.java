public class Solution {
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        for (int i = 2; i * i < n; ++ i)
            if (!isNotPrime[i])
                for (int j = i * i; j < n; j += i)
                    isNotPrime[j] = true;
        int count = 0;                    
        for (int i = 2; i < n; ++ i)
            if (!isNotPrime[i])
                count ++;
        return count;
    }
}