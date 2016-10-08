public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, count1 = 0;
        int candidate2 = 0, count2 = 0;
        for (int i = 0; i < nums.length; ++ i) {
            if (count1 == 0) {
                candidate1 = nums[i];
                count1 ++;
                continue;
            }
            if (nums[i] != candidate1 && count2 == 0) {
                candidate2 = nums[i];
                count2 ++;
                continue;
            }
            if (nums[i] == candidate1) {
                count1 ++;
                continue;
            }
            if (nums[i] == candidate2) {
                count2 ++;
                continue;
            }
            count1--;
            count2--;
        }
        int c1 = 0, c2 = 0;
        for (int i = 0; i < nums.length; ++ i) {
            if (nums[i] == candidate1) {
                c1 ++;
            } else if (nums[i] == candidate2) {
                c2 ++;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0) {
            return result;
        }
        if (c1 > 0 && c1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (c2 > 0 && c2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }
}