public class NumArray {

    int[] nums;
    int[] sum;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        this.nums = nums;
        this.sum = new int[nums.length];
        initialize(1, 0, min.length - 1);
    }

    void initialize(int node, int b, int e) {
        if (b == e)
            sum[node] = b;
        else {
            //compute the values in the left and right subtrees
            initialize(2 * node, b, (b + e) / 2);
            initialize(2 * node + 1, (b + e) / 2 + 1);
            //search for the minimum value in the first and
            //second half of the interval
            if (nums[min[2 * node]] <= nums[min[2 * node + 1]])
                min[node] = min[2 * node];
            else
                min[node] = min[2 * node + 1];
        }
    }

    void update(int i, int val) {
        
    }

    public int sumRange(int i, int j) {
        
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
