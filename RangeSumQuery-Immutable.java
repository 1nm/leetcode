public class NumArray {
    int[] sum;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        for (int i = 0; i < nums.length; ++ i) {
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - sum[i] + nums[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);