public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Map<Integer, Set<Integer>> divisors = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++ i) {
            int divisor = -1, maxLen = 0;
            for (int num : divisors.keySet()) {
                if (nums[i] % num == 0 && maxLen < divisors.get(num).size()) {
                    divisor = num;
                    maxLen = divisors.get(num).size();
                }
            }
            Set<Integer> set = new HashSet<>(Arrays.asList(nums[i]));
            if (divisor != -1) {
                set.addAll(divisors.get(divisor));
            }
            divisors.put(nums[i], set);
        }
        Set<Integer> max = new HashSet<>();
        for (int num : divisors.keySet()) {
            Set<Integer> set = divisors.get(num);
            if (max.size() < set.size()) {
                max = set;
            }
        }
        return new ArrayList<>(max);
    }
}