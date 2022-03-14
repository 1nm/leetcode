public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] result = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxNumber(nums1, i), maxNumber(nums2, k - i));
            if (greater(candidate, result, 0, 0)) result = candidate;
        }
        return result;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int i = 0, j = 0, l = 0;
        for (;l < k; ++l)
            result[l] = (greater(nums1, nums2, i, j) ? nums1[i++] : nums2[j++]);
        return result;
    }

    // merge by sorting suffix lexically
    private int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int num : nums1) sb1.append(num);
        for (int num : nums2) sb2.append(num);

        for (int i = 0, j = 0, k = 0; k < nums1.length + nums2.length; ++ k) {
            result[k] = (i < nums1.length ? sb1.substring(i) : "").compareTo((j < nums2.length ? sb2.substring(j) : "")) > 0 ? nums1[i++] : nums2[j++];
        }
        return result;
    }

    private boolean greater(int[] nums1, int[] nums2, int i, int j) {
        int n1 = nums1.length, n2 = nums2.length;
        while (i < n1 && j < n2 && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == n2 || (i < n1 && nums1[i] > nums2[j]);
    }

    private int[] maxNumber(int[] nums, int k) {
        int[] result = new int[k];
        for (int i = 0, j = 0; i < nums.length; ++ i) {
            while (nums.length - i + j > k && j > 0 && result[j - 1] < nums[i]) j --;
            if (j < k) result[j++] = nums[i];
        }
        return result;
    }

}
