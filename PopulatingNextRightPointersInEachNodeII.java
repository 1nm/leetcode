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
        Queue<TreeLinkNode> q = new LinkedList<>();
        if (root == null)
            return;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode curr = null;
            TreeLinkNode pre = null;
            for (int i = 0; i < size; ++ i) {
                pre = curr;
                curr = q.poll();
                if (i > 0) {
                    pre.next = curr;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            curr.next = null;
        }
    }
}
