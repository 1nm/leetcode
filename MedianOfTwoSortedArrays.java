public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n == 0 && m == 0)
            return 0;

        if (n > m) {
            int[] nums = nums1;
            nums1 = nums2;
            nums2 = nums;
            int temp = n;
            n = m;
            m = temp;
        }

        int lo = 0, hi = n, hl = (n + m + 1) / 2;
        double median;

        while (lo <= hi) {
            // p1 and p2 is pivot of nums1 and nums2 where p1 + p2 == half length
            int p1 = (lo + hi) / 2;
            int p2 = hl - p1;
            if (p2 > 0 && p1 < n && nums2[p2 - 1] > nums1[p1])
                lo = p1 + 1;
            else if (p1 > 0 && p2 < m && nums1[p1 - 1] > nums2[p2])
                hi = p1 - 1;
            else {
                int maxl, minr;
                if (p1 == 0)
                    maxl = nums2[p2 - 1];
                else if (p2 == 0)
                    maxl = nums1[p1 - 1];
                else
                    maxl = Math.max(nums1[p1 - 1], nums2[p2 - 1]);
                if ((n + m) % 2 == 1) {
                    median = maxl;
                    break;
                }
                if (p1 == n)
                    minr = nums2[p2];
                else if (p2 == m)
                    minr = nums1[p1];
                else
                    minr = Math.min(nums1[p1], nums2[p2]);
                median = (maxl + minr) / 2.0;
                break;
            }
        }

        return median;
    }
}
