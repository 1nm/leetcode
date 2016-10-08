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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            traversal.add(node.val);
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return traversal;
    }
}