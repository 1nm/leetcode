/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (p != null) {
            p = p.next;
            if (p == null) {
                break;
            } else {
                p = p.next;
            }
            q = q.next;
            if (p == q) {
                return true;
            }
        }
        return false;
    }
}