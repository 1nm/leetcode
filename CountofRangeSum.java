public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        List<Long> candidate = new ArrayList<>();
        candidate.add(Long.MIN_VALUE);
        candidate.add(0L);
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++ i) {
            sums[i + 1] = sums[i] + nums[i];
            candidate.add(sums[i + 1]);
            candidate.add(sums[i] + lower - 1);
            candidate.add(sums[i] + upper);
        }
        Collections.sort(candidate);

        int[] bits = new int[candidate.size()];
        for (int i = 0; i < sums.length; ++ i) add(bits, Collections.binarySearch(candidate, sums[i]), 1);

        int result = 0;

        for (int i = 1; i < sums.length; ++ i) {
            add(bits, Collections.binarySearch(candidate, sums[i - 1]), -1);
            result += sum(bits, Collections.binarySearch(candidate, sums[i - 1] + upper)) - sum(bits, Collections.binarySearch(candidate, sums[i - 1] + lower - 1));
        }

        return result;
    }

    private void add(int[] bits, int i, int val) {
        for (; i < bits.length; i += i&-i) bits[i] += val;
    }

    private int sum(int[] bits, int i) {
        int sum = 0;
        for (; i > 0; i -= i&-i) sum += bits[i];
        return sum;
    }
}
