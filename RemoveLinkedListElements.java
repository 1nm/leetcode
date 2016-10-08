/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q = p;
        while (p != null) {
            if (p.val == val) {
                if (head == p) {
                    head = p.next;
                } else {
                    q.next = p.next;
                }
                p = p.next;
            } else {
                q = p;
                p = p.next;
            }
        }
        return head;
    }
}