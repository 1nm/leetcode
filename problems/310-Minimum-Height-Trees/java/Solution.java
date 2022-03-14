public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer> vertices = new HashSet<Integer>();
        Map<Integer, List<Integer>> e = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; ++ i) {
            vertices.add(i);
        }
        for (int i = 0; i < edges.length; ++ i) {
            List<Integer> v1 = e.get(edges[i][0]);
            List<Integer> v2 = e.get(edges[i][1]);
            if (v1 == null) {
                v1 = new ArrayList<Integer>();
            }
            if (v2 == null) {
                v2 = new ArrayList<Integer>();
            }
            v1.add(edges[i][1]);
            v2.add(edges[i][0]);
            e.put(edges[i][0], v1);
            e.put(edges[i][1], v2);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        while (vertices.size() > 2) {
            leaves.clear();
            for (int u : vertices) {
                int count = 0;
                List<Integer> list = e.get(u);
                if (list != null) {
                    for (int v : list) {
                        if (vertices.contains(v)) {
                            count++;
                        }
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
