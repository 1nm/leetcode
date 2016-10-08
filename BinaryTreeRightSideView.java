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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++ i) {
                TreeNode node = q.poll();
                if (i == 0) {
                    view.add(node.val);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
            }
        }
        return view;
    }
}