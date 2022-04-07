public class Solution {
  public int maximumTop(int[] nums, int k) {
      if (nums.length == 1 && k % 2 == 1) return -1;
      // some observations
      // if k > nums.length it's simply find max number in array
      // if k <= nums.length
      // we can't make nums[k - 1] the topmost because we need k steps to take this number;
      // but we can make nums[k] the topmost by removing all [0, k - 1] numbers
      int max = 0;
      if (k > nums.length) {
          for (int i = 0; i < nums.length; i ++) {
              if (max < nums[i]) {
                  max = nums[i];
              }
          }
          return max;
      } else {
          for (int i = 0; i < k - 1; i ++) {
              if (max < nums[i]) {
                  max = nums[i];
              }
          }
          if (k < nums.length) { // we have nums[k]
              return Math.max(max, nums[k]);
          } else {
              return max;
          }
      }
  }
}