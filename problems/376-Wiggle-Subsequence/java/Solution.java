class Solution {
  public int wiggleMaxLength(int[] nums) {
    int len = nums.length;
    int[] inc = new int[len];
    int[] dec = new int[len];
    inc[0] = 1;
    dec[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        inc[i] = inc[i - 1];
        dec[i] = dec[i - 1];
      } else if (nums[i] > nums[i - 1]) {
        dec[i] = inc[i - 1] + 1;
        inc[i] = inc[i - 1];
      } else {
        inc[i] = dec[i - 1] + 1;
        dec[i] = dec[i - 1];
      }
    }
    return Math.max(inc[len - 1], dec[len - 1]);
  }
}
