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
    public void flatten(TreeNode root) {
        TreeNode newRoot = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // pre-order traversal
        TreeNode p = root;
        TreeNode pre = p;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                TreeNode node = p;
                if (p.right != null) {
                    stack.push(p.right);
                }
                p = p.left;
                if (newRoot == null) {
                    pre = newRoot = node;
                } else {
                    pre.left = null;
                    pre.right = node;
                    pre = node;
                }
            } else {
                p = stack.pop();
            }
        }
    }
}