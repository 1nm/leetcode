/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        //level order traversal
        LinkedList<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if (root != null) {
            q.add(root);
        }
        int count = 0;

        TreeLinkNode pre = root;

        while (!q.isEmpty()) {
            TreeLinkNode node = q.poll();
            count ++;
            if ((count & (count - 1)) == 0) { // power of 2
                pre.next = null;
            } else {
                pre.next = node;
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
            pre = node;
        }

    }

}
