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
    TreeNode root;
    int depth = 0;
    public int countNodes(TreeNode root) {
        this.root = root;
        while (root != null) {
            this.depth++;
            root = root.left;
        }
        if (this.depth == 0) {
            return 0;
        } else {
            return count();
        }
    }

    private int count() {
        int start = 0;
        int end = (1 << (this.depth - 1)) - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (find(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (1 << (this.depth - 1)) + start;
    }

    private boolean find(int path) {
        TreeNode node = this.root;
        int depth = this.depth - 1;
        while (node != null && depth > 0) {
            if ((path & (1 << (depth - 1))) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            depth --;
        }
        return node != null;
    }
}
