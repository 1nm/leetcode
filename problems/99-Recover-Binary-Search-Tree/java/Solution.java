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
    
    TreeNode first, second, prev;
    
    public void recoverTree(TreeNode root) {
        inOrderTraverse(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }
    
    private void inOrderTraverse(TreeNode node) {
        if (node == null) return;
        inOrderTraverse(node.left);
        if (prev != null && node.val < prev.val && first == null) {
            first = prev;
            second = node;
        }
        if (prev != null && node.val < prev.val && first != null)
            second = node;
        prev = node;
        inOrderTraverse(node.right);
    }
}