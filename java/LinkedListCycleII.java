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
    public ListNode detectCycle(ListNode head) {
        ListNode p = head, q = head;
        while (p != null) {
            p = p.next;
            if (p == null) {
                break;
            } else {
                p = p.next;
            }
            q = q.next;
            if (p == q) {
                p = head;
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }
}