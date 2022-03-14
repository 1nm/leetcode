public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; ++ i) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            List<String> list = null;
            if (map.containsKey(sorted)) {
                list = map.get(sorted);
            } else {
                list = new ArrayList<String>();
                map.put(sorted, list);
            }
            list.add(strs[i]);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (List<String> list : map.values()) {
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}