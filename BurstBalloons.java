/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/

public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] newNums = new int[n + 2];
        System.arraycopy(nums, 0, newNums, 1, n);
        newNums[0] = newNums[n + 1] = 1;

        int[][] max = new int[n + 2][];
        for (int i = 0; i < n + 2; ++ i) {
            max[i] = new int[n + 2];
        }

        for (int i = 0; i < n + 2; ++ i) {
            for (int j = i + 2; j < n + 2; ++ j) {
                for (int k = i + 1; k < j; ++ k) {
                    max[i][j] = Math.max(max[i][j], newNums[k - 1]* newNums[k] * newNums[k + 1] + max[i][k] + max[k][j]);
                }
            }
        }
        return max[0][n + 1];
    }
}
