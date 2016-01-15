public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer> vertices = new HashSet<Integer>();
        List<List<Integer>> e = new ArrayList<List<Integer>>;
        for (int i = 0; i < n; ++ i) {
            vertices.add(i);
            e.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; ++ i) {
            e.get(edges[i][0]).add(edges[i][1]);
            e.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        while (vertices.size() > 2) {
            leaves.clear();
            for (int u : vertices) {
                int count = 0;
                for (int v : e.get(u)) {
                    if (vertices.contains(v)) {
                        count++;
                    }
                }
                if (count == 1) {
                    leaves.add(u);
                }
            }
            for (int u : leaves) {
                vertices.remove(u);
            }
        }
        return new ArrayList(vertices);
    }
}
