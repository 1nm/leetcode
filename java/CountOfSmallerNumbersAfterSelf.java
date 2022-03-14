public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        Map<Integer, Integer> rank = new HashMap<>();
        Arrays.asList(nums);
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length; ++ i) {
            rank.put(sorted[i], i + 1);
        }
        FenwickTree tree = new FenwickTree(nums.length);
        for (int i = nums.length - 1; i >= 0; -- i) {
            result.add(0, tree.sum(rank.get(nums[i]) - 1));
            tree.add(rank.get(nums[i]), 1);
        }
        return result;
    }

    class FenwickTree {
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
}