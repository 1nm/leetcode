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
    int total;
    public int sumNumbers(TreeNode root) {
        total = 0;
        visit(root, 0);
        return this.total;
    }
    
    private void visit(TreeNode node, int sum) {
        if (node != null) {
            sum *= 10;
            sum += node.val;
            if (node.left == null && node.right == null) {
                // leaf
                this.total += sum;
            } else {
                visit(node.left, sum);
                visit(node.right, sum);
            }
        }
    }
}