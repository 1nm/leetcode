public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> bst = new TreeSet();
        for (int i = 0; i < nums.length; ++ i) {
            if (i > k) bst.remove((long) nums[i - k - 1]); // maintain k-size window
            long num = (long) nums[i];
            Long floor = bst.floor(num);
            Long ceil = bst.ceiling(num);
            if (floor != null && floor + t >= num || ceil != null && num + t >= ceil) return true;
            bst.add(num);
        }
        return false;
    }
}
