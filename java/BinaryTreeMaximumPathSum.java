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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxNodeSum(root);
        return max;
    }
    
    private int maxNodeSum(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxNodeSum(node.left));
        int right = Math.max(0, maxNodeSum(node.right));
        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}