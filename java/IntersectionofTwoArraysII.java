public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; ++ i) {
            map.put(nums1[i], map.containsKey(nums1[i]) ? map.get(nums1[i]) + 1 : 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; ++ i) {
            if (map.containsKey(nums2[i])) {
                result.add(nums2[i]);
                int count = map.get(nums2[i]);
                if (count == 1)
                    map.remove(nums2[i]);
                else
                    map.put(nums2[i], count -1);
            }
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); ++ i)
            array[i] = result.get(i);
        return array;
    }
}