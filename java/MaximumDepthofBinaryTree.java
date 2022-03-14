/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        } else {
            return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
        }
    }
}