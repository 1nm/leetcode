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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postOrderIterative(result, root);
        return result;
    }
    
    
    // recursive implementation of post-order traversal
    private void postOrder(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(result, node.left);
        postOrder(result, node.right);
        result.add(node.val);
    }
    
    // iterative implementation of post-order traversal
    private void postOrderIterative(List<Integer> result, TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode lastVisited = null;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && lastVisited != peek.right) {
                    node = peek.right;
                } else {
                    lastVisited = stack.pop();
                    result.add(lastVisited.val);
                }
            }
        }
    }
}