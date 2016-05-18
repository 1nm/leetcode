public class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        if (nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        int m = Integer.MIN_VALUE;
        Arrays.fill(max, 1);
        for (int i = 0; i < nums.length; ++ i) {
            for (int j = 0; j < i; ++ j) {
                if (nums[i] > nums[j]) {
                    max[i] = max[i] > max[j] + 1 ? max[i] : max[j] + 1;
                }
            }
            m = m > max[i] ? m : max[i];
        }
        return m;
        */

        /*
          Alternative nlogn solution
          We have elements: a_{1},a_{2},a_{3},\ldots ,a_{i}.

          And we have a longest increasing subsequences of them: A_{{i,1}}<A_{{i,2}}<\ldots <A_{{i,j}}, for any A_{{i,k}}(1<=k<=j) you could not find a smaller alternative.

          Now we have a new element: a_{{i+1}}

          What we can do about it:

          1. insert it at the back if A_{{i,j}}<a_{{i+1}}, where we will have a longer one;

          2. make it an alternative for A_{{i,k}} if A_{{i,k-1}}<a_{{i+1}}\ AND\ a_{{i+1}}<=A_{{i,k}}

          Alternative means that we MIGHT get longer ones if using the new element.
        */

        List<Integer> lis = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++ i) {
            int start = 0;
            int end = lis.size() - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int curr = lis.get(mid);
                if (curr == nums[i]) {
                    break;
                } else if (curr < nums[i]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            if (start == lis.size()) {
                lis.add(nums[i]);
            } else {
                lis.set(start, nums[i]);
            }
        }
        return lis.size();
    }
}
