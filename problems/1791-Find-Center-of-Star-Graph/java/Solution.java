import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int findCenter(int[][] edges) {
    Set<Integer> vertice = new HashSet<>();
    // Center node should has n - 1 degrees while all other nodes have 1 degree
    for (int[] edge : edges) {
      if (vertice.contains(edge[0]))
        return edge[0];
      if (vertice.contains(edge[1]))
        return edge[1];
      vertice.add(edge[0]);
      vertice.add(edge[1]);
    }
    return -1; // should not be reached
  }
}
