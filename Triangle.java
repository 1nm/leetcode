public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0) {
            return 0;
        }
        int[] min = new int[row];
        for (int i = row - 1; i >= 0; -- i) {
            List<Integer> nums = triangle.get(i);
            for (int j = 0; j < nums.size(); ++ j) {
                if (i == row - 1) {
                    min[j] = nums.get(j);
                } else {
                    min[j] = Math.min(min[j], min[j + 1]) + nums.get(j);
                }
            }
        }
        return min[0];
    }
}