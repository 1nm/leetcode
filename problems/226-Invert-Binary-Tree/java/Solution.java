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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode left = invertTree(root.right);
            TreeNode right = invertTree(root.left);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}