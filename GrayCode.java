public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> gc = new ArrayList<Integer>();
        gc.add(0);
        // reflect and mirror method
        for (int i = 1; i <= n; ++ i) {
            int size = gc.size();
            for (int j = size - 1; j >= 0; -- j) {
                int code = gc.get(j);
                gc.add(code | (1 << (i - 1)));
            }
        }
        return gc;
    }
}
