public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; ++ i) {
            for (int j = i + 1; j < nums.length; ++ j) {
                int twosum = target - nums[i] - nums[j];
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    if (twosum ==  nums[k] + nums[l]) {
                        List<Integer> quaduplet = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        if (!set.contains(quaduplet)) {
                            set.add(quaduplet);
                            result.add(quaduplet);
                        }
                        k ++;
                    } else if (twosum < nums[k] + nums[l]) {
                        l --;
                    } else {
                        k ++;
                    }
                }
            }
        }
        return result;
    }
}

//////////////////////////////////////////////////////////////////////////////////
// import java.util.Set;                                                       //
// import java.util.HashSet;                                                   //
// import java.util.List;                                                      //
// import java.util.ArrayList;                                                 //
// import java.util.Collections;                                               //
//                                                                             //
// public class FourSum {                                                      //
//     public static void main(String[] args) {                                //
//         new FourSum().fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0);           //
//     }                                                                       //
//                                                                             //
//     public List<List<Integer>> fourSum(int[] nums, int target) {            //
//         Set<Pair> pairset = new TreeSet<Pair>();                            //
//         for (int i = 0; i < nums.length; ++ i) {                            //
//             for (int j = i + 1; j < nums.length; ++ j) {                    //
//                 pairset.add(new Pair(nums[i], nums[j]));                    //
//             }                                                               //
//         }                                                                   //
//         List<Pair> pairs = new ArrayList<Pair>();                           //
//         pairs.addAll(pairset);                                              //
//         Collections.sort(pairs);                                            //
//         for (int i = 0; i < pairs.size(); ++ i) {                           //
//             Pair pair = pairs.get(i);                                       //
//             System.out.println("("+ pair.a + "," + pair.b + ")");           //
//         }                                                                   //
//         return null;                                                        //
//     }                                                                       //
//                                                                             //
//     private Pair search(List<Pair> pairs, int start, int end, Pair target) { //
//         while (start <= end) {                                              //
//             int mid = (start + end) / 2;                                    //
//             int compare = pairs.get(mid).compareTo(target);                 //
//             if (compare == 0) {                                             //
//                 return pairs.get(mid);                                      //
//             } else if (compare < 0) {                                       //
//                 end = mid - 1;                                              //
//             } else {                                                        //
//                 start = mid + 1;                                            //
//             }                                                               //
//         }                                                                   //
//         return null;                                                        //
//     }                                                                       //
//                                                                             //
//     private static class Pair implements Comparable<Pair> {                 //
//         int a, b;                                                           //
//         Pair(int x, int y) {                                                //
//             if (x < y) {                                                    //
//                 a = x;                                                      //
//                 b = y;                                                      //
//             } else {                                                        //
//                 a = y;                                                      //
//                 b = x;                                                      //
//             }                                                               //
//         }                                                                   //
//                                                                             //
//         @Override                                                           //
//         public int compareTo(Pair o) {                                      //
//             if (a + b == o.a + o.b) {                                       //
//                 if (a == o.a) {                                             //
//                     return 0;                                               //
//                 } else {                                                    //
//                     return a - o.a;                                         //
//                 }                                                           //
//             } else {                                                        //
//                 return a + b - o.a - o.b;                                   //
//             }                                                               //
//         }                                                                   //
//     }                                                                       //
// }                                                                            //
//////////////////////////////////////////////////////////////////////////////////
