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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> routes = new ArrayList<String>();
        if (root == null) {
            return routes;
        }
        dfs(routes, "", root);
        return routes;
    }
    
    private void dfs(List<String> routes, String route, TreeNode node) {
        route += route.length() == 0 ? String.valueOf(node.val) : "->" + String.valueOf(node.val);
        if (node.left == null && node.right == null) {
            routes.add(route);
        } else {
            if (node.left != null) {
                dfs(routes, route, node.left);
            }
            if (node.right != null) {
                dfs(routes, route, node.right);
            }
        }
    }
}