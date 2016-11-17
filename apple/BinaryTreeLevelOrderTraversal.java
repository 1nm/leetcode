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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // pay special attention to edge data, root is null
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                nodes.add(node);
                list.add(node.val);
            }
            result.add(list);
            for (TreeNode node : nodes) {
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return result;
    }
}
