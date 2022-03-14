public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comp = (int[] p1, int[] p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : - p1[0] + p2[0];
        Arrays.sort(people, comp);
        List<int[]> ret = new LinkedList<>();
        for (int[] p : people) {
            ret.add(p[1], p);
        }
        return ret.toArray(new int[people.length][]);
    }
}
