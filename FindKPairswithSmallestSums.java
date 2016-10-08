public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[0] + a[1] == b[0] + b[1] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[0] + a[1] - b[0] - b[1]);
        List<int[]> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return result;
        int len1 = k < nums1.length ? k : nums1.length;
        int len2 = k < nums2.length ? k : nums2.length;
        for (int i = 0; i < len1; ++ i)
            for (int j = 0; j < len2; ++ j)
                q.add(new int[] {nums1[i], nums2[j]});
        while (!q.isEmpty() && result.size() < k)
            result.add(q.poll());
        return result;
    }
}