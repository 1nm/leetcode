# 886. Possible Bipartition
- Difficulty: Medium
- Acceptance: 47.0% (as of 2022-03-14)

## Solutions
   * A typical graph bipartition problem. Consider each person as a vertex, and each dislike as an edge.
   * The graph is bipartite if any of the following is true
     1. The graph can be colored with two colors such that no two adjacent vertices are colored with the same color
     1. There is no odd cycle in the graph.
   * DFS, BFS or Union Find can be used to solve this problem
   * Time O(V + E), Space O(V + E)
