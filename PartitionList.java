/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // dummy head
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        head = newHead;
        ListNode p = head;
        ListNode pre = p;
        
        // find first node that is greater than given value
        while (p != null && p.val < x) {
            pre = p;
            p = p.next;
        }
        
        // find nodes which are less than given value and insert them after the above node
        if (p != null) {
            ListNode ins = pre;
            while (p != null) {
                if (p.val < x) {
                    pre.next = p.next;
                    p.next = ins.next;
                    ins.next = p;
                    ins = p;
                    p = pre.next;
                } else {
                    pre = p;
                    p = p.next;
                }
            }
        }
        
        return head.next;
    }
}