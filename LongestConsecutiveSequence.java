public class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 1;
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < nums.length; ++ i) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; ++ i) {
            if (visited.contains(nums[i])) {
                continue;
            }
            int currLongest = 1;
            visited.add(nums[i]);
            int n = nums[i] + 1;
            while (set.contains(n)) {
                visited.add(n++);
                currLongest += 1;
            }
            n = nums[i] - 1;
            while (set.contains(n)) {
                visited.add(n--);
                currLongest += 1;
            }
            if (longest < currLongest) {
                longest = currLongest;
            }
        }
        return longest;
    }
}