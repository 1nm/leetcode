/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        return bst(0, countNodes(head) - 1);
    }
    
    private int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count ++;
            head = head.next;
        }
        return count;
    }

    private TreeNode bst(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = bst(start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        this.head = this.head.next;
        TreeNode right = bst(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}