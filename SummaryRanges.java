public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();
        int start = 0;
        int i = 0;
        while (i < nums.length) {
            if (i > 0 && nums[i] != nums[i - 1] + 1) {
                ranges.add(getRange(nums, start, i - 1));
                start = i;
            }
            i ++;
        }
        if (start < nums.length) {
            ranges.add(getRange(nums, start, nums.length - 1));
        }
        return ranges;
    }
    
    private String getRange(int[] nums, int start, int end) {
                if (start == end) {
                    return String.valueOf(nums[start]);
                } else {
                    return String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]);
                }
    }
}