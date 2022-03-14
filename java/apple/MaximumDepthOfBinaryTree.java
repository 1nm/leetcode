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
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int currentDepth) {
        if (node == null) return currentDepth;
        int left = maxDepth(node.left, currentDepth + 1);
        int right = maxDepth(node.right, currentDepth + 1);
        return left > right ? left : right;
    }
}
