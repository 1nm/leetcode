public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        for (int i = 0; i < primes.length; ++ i) {
            q.add(new Node(primes[i], primes[i], 0));
        }
        for (int i = 1; i < n; ++ i) {
            Node node = q.peek();
            ugly[i] = node.val;
            do {
                node = q.poll();
                node.val = ugly[++ node.index] * node.factor;
                q.add(node);
            }
            while (!q.isEmpty() && node.val == ugly[i]);

        }
        return ugly[n - 1];
    }

    public class Node implements Comparable<Node> {
        int val;
        int factor;
        int index;

        public Node(int val, int factor, int index) {
            this.val = val;
            this.factor = factor;
            this.index = index;
        }

        public int compareTo(Node that) {
            return this.val - that.val;
        }
    }
}
