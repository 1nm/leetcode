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
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // visit node
            node = stack.pop();
            count ++;
            if (count == k) {
                return node.val;
            }
            // visit right sub tree
            node = node.right;
        }
        return -1;
    }
}
