public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; ++ i) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < i - 1; ++ j) {
                row.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
            }
            if (i > 0)
                row.add(1);
            result.add(row);
        }
        return result;
    }
}
