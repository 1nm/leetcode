class Solution {
  public int maxRotateFunction(int[] nums) {
    // f[i] = f[i - 1] + sum - nums.length * nums[nums.length - i]
    int[] f = new int[nums.length];
    int sum = 0;
    // initialize sum and f[0]
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      f[0] += i * nums[i];
    }
    int max = f[0];
    for (int i = 1; i < nums.length; i++) {
      f[i] = f[i - 1] + sum - nums.length * nums[nums.length - i];
      max = Math.max(max, f[i]);
    }
    return max;
  }
}
