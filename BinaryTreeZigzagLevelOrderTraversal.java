// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currLevel = new ArrayList<Integer>();
        if (root != null) {
            Stack<TreeNode> curr = new Stack<TreeNode>();
            Stack<TreeNode> next = new Stack<TreeNode>();
            Stack<TreeNode> temp = null;
            int depth = 0;
            curr.push(root);
            while(!curr.isEmpty()) {
                while (!curr.isEmpty()) {
                    TreeNode node = curr.pop();
                    currLevel.add(node.val);
                    if (depth % 2 == 0) {
                        if (node.left != null) {
                            next.push(node.left);
                        }
                        if (node.right != null) {
                            next.push(node.right);
                        }
                    } else {
                        if (node.right != null) {
                            next.push(node.right);
                        }
                        if (node.left != null) {
                            next.push(node.left);
                        }
                    }
                }
                result.add(new ArrayList<Integer>(currLevel));
                currLevel.clear();
                temp = curr;
                curr = next;
                next = temp;
                depth ++;
            }
        }
        return result;
    }
}
