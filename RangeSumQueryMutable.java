public class NumArray {

    // BIT implementation

    int[] nums;
    int[] sum;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        this.nums = new int[nums.length];
        this.sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++ i) {
            update(i + 1, nums[i]);
        }
    }

    int sum(int i) {
        int result = 0;
        while (i > 0) {
            result += sum[i];
            i -= (i & -i);
        }
        return result;
    }

    void update(int i, int val) {
        int diff = val - this.nums[i - 1];
        if (diff == 0) return;
        this.nums[i - 1] = val;
        while (i < sum.length) {
            sum[i] += diff;
            i += (i & -i);
        }
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
