public class Solution {
    public int nthUglyNumber(int n) {
        long u = 1;
        PriorityQueue<Long> ugly = new PriorityQueue<Long>();
        for (int i = 0; i < n - 1; ++ i) {
            ugly.add(u * 2);
            ugly.add(u * 3);
            ugly.add(u * 5);
            while (u == ugly.peek()) {
                ugly.poll();
            }
            u = ugly.poll();
        }
        return (int) u;
    }
}