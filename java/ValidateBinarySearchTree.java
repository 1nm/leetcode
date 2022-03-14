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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        } else {
            return root.val > min && root.val < max && isValid(root.left, min, Math.min(root.val, max)) && isValid(root.right, Math.max(root.val, min), max);
        }
    }

}