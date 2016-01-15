/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        TreeNode pre = null;
        TreeNode node = head;
        while(node != null) {
            TreeNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
    }
}
