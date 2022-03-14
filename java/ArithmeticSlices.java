public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int[] diff = new int[A.length];
        int[] count = new int[A.length];
        for (int i = 1; i < A.length; ++ i)
            diff[i] = A[i] - A[i - 1];
        for (int i = 2; i < A.length; ++ i) {
            count[i] = count[i - 1];
            int j = i - 1;
            while (j > 0 && diff[i] == diff[j--])
                count[i] ++;
        }
        return count[A.length - 1];
    }
}
