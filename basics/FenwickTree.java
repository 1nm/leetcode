public class FenwickTree {
    int[] tree;
    public FenwickTree(int length) {
        this.tree = new int[length + 1];
    }
    /* add val to pos i */
    public void add(int i, int val) {
        while (i < tree.length) {
            tree[i] += val;
            i += i & -i;
        }
    }
    /* returns sum [0 .. i) */
    public int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }
}
