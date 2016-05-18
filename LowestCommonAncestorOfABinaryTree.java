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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ppath = search(root, p);
        List<TreeNode> qpath = search(root, q);
        TreeNode lca = null;
        int i = 0;
        while (i < ppath.size() && i < qpath.size() && ppath.get(i) == qpath.get(i)) {
            lca = ppath.get(i);
        }
        return lca;
    }

    private List<TreeNode> search(TreeNode root, TreeNode target) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode lastVisited = null;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek == target) {
                    break;
                } else if (peek.right != null && lastVisited != peek.right) {
                    node = peek.right;
                } else {
                    lastVisited = stack.pop();
                }
            }
        }
        return new ArrayList<TreeNode>(stack);
    }
}
