class Solution {
  // Color the graph with two colors in a DFS manner
  private boolean color(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> colors, int u,
      int color) {
    // System.out.println("Coloring " + u);
    if (colors.containsKey(u)) {
      if (colors.get(u) != color) {
        // System.out.println(u + " " + color);
        return false; // already colored with a different color
      }
    } else {
      colors.put(u, color);
      if (graph.containsKey(u)) {
        for (int v : graph.get(u)) {
          if (!color(graph, colors, v, 1 - color)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public boolean possibleBipartition(int n, int[][] dislikes) {
    // can be bipartitioned only if the graph is 2-colorable
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] edge : dislikes) {
      Set<Integer> adjNodes = graph.getOrDefault(edge[0], new HashSet<>());
      adjNodes.add(edge[1]);
      graph.put(edge[0], adjNodes);
      Set<Integer> adjNodes1 = graph.getOrDefault(edge[1], new HashSet<>());
      adjNodes1.add(edge[0]);
      graph.put(edge[1], adjNodes1);
    }
    Map<Integer, Integer> colors = new HashMap<>();

    for (int node : graph.keySet()) {
      // System.out.println("DFS " + node);
      if (!colors.containsKey(node) && !color(graph, colors, node, 0)) {
        return false;
      }
    }
    return true;
  }
}
