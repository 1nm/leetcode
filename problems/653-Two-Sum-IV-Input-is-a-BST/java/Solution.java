class Solution {
  // DFS
  private boolean dfs(TreeNode node, Set<TreeNode> visited, Set<Integer> vals, int k) {
    if (node == null)
      return false;
    if (visited.contains(node))
      return false;
    int target = k - node.val;
    if (vals.contains(target))
      return true;
    visited.add(node);
    vals.add(node.val);
    return dfs(node.left, visited, vals, k) || find(node.right, visited, vals, k);
  }

  public boolean findTarget(TreeNode root, int k) {
    return dfs(root, new HashSet<>(), new HashSet<>(), k);
  }
}
