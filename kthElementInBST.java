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
    public int kthSmallest(TreeNode root, int k) {
        // iterative in-order traversal of BST, return kth element
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        int count = 0;
        // visit left sub tree
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            // visit node
            node = stack.pop();
            count ++;
            if (count == k) {
                return node.val;
            }
            // visit right sub tree
            node = node.right;
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        }
        return -1;
    }
}
