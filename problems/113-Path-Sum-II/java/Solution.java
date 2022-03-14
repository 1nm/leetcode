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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        search(root, sum, result, path);
        return result;
    }
    
    private void search(TreeNode node, int value, List<List<Integer>> result, LinkedList<Integer> path) {
        if (node == null) {
            return; // should not happen
        }
        if (node.left == null && node.right == null) {
            if (node.val == value) {
                path.add(node.val);
                result.add(new ArrayList(path));
                path.pollLast();
            }
        } else {
            path.add(node.val);
            if (node.left != null) {
                search(node.left, value - node.val, result, path);
            }
            if (node.right != null) {
                search(node.right, value - node.val, result, path);
            }
            path.pollLast();
        }
        
    }
}