public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] - nums[1] : nums[1] - nums[0];
        int min = nums[0], max = nums[0];
        // find min and max;
        for (int i = 0; i < nums.length; ++ i) {
            if (nums[i] < min)
                min = nums[i];
            if (nums[i] > max)
                max = nums[i];
        }
        int range = Math.max(1, (int) Math.ceil((double) (max - min) / (nums.length - 1)));
        int len = (max - min) / range + 1;
        int[][] buckets = new int[len][];

        for (int i = 0; i < nums.length; ++ i) {
            int index = (nums[i] - min) / range;
            if (buckets[index] == null) {
                buckets[index] = new int[] {nums[i], nums[i], 1};
            } else {
                buckets[index][2] ++;
                if (nums[i] < buckets[index][0])
                    buckets[index][0] = nums[i];
                if (nums[i] > buckets[index][1])
                    buckets[index][1] = nums[i];
            }
        }

        int maxGap = 0;

        for (int i = 0; i < buckets.length - 1; ++ i) {
            if (buckets[i] != null) {
                int j = i + 1;
                while (j < buckets.length && buckets[j] == null)
                    j ++;
                if (j < buckets.length)
                    maxGap = Math.max(maxGap, buckets[j][0] - buckets[i][1]);
            }
        }

        return maxGap;
    }
}
