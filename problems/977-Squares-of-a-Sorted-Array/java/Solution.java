public class Solution {
  public int[] sortedSquares(int[] nums) {
    int len = nums.length;
    int p = 0, q = len - 1;
    int[] res = new int[len];
    int count = 0;
    while (p <= q) {
      int squareP = nums[p] * nums[p];
      int squareQ = nums[q] * nums[q];
      if (squareP > squareQ) {
        res[count] = squareP;
        p++;
      } else {
        res[count] = squareQ;
        q--;
      }
      count++;
    }
    // swap res
    for (int i = 0; i < len / 2; i++) {
      int temp = res[i];
      res[i] = res[len - 1 - i];
      res[len - 1 - i] = temp;
    }
    return res;
  }
}
