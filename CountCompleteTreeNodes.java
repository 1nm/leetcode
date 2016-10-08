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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        TreeNode node = root;
        while (node != null) {
            depth ++;
            node = node.left;
        }
        int start =  0;
        int end = (1 << (depth - 1)) - 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (find(root, depth, mid)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return (1 << (depth - 1)) + start;
    }
    
    // check if node n (starts from 0) exists in depth d
    private boolean find(TreeNode root, int depth, int n) {
        TreeNode node = root;
        int curr = 1;
        while (curr < depth && node != null) {
            boolean left = ((1 << (depth - curr - 1)) & n) == 0;
            if (left) {
                node = node.left;
            } else {
                node = node.right;
            }
            curr ++;
        }
        return (node != null);
    }
}