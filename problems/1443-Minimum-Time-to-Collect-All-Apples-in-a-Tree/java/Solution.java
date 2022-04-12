import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
  private int dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited,
      List<Boolean> hasApple) {
    visited.add(node);
    int res = 0;
    List<Integer> adjNodes = graph.get(node);
    if (adjNodes != null) {
      for (int i = 0; i < adjNodes.size(); i++) {
        int j = adjNodes.get(i);
        if (!visited.contains(j)) {
          res += dfs(j, graph, visited, hasApple);
        }
      }
    }
    if (node != 0 && (hasApple.get(node) || res > 0)) {
      res += 2;
    }
    return res;
  }

  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      graph.putIfAbsent(u, new ArrayList<>());
      graph.putIfAbsent(v, new ArrayList<>());
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    System.out.println(graph);
    return dfs(0, graph, visited, hasApple);
  }

  public static void main(String[] args) {
    int n = 7;
    int[][] edges = new int[][] {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
    List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
    System.out.println(new Solution().minTime(n, edges, hasApple));
  }
}
