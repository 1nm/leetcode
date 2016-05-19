/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode node = head;
        int i = 0;
        while (node != hull) {
            i ++;
            if (i % k == 0) {
                pre = reverse(pre, node.next);
                node = pre.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }

    // reverse linked list from b to e exclusively and returns the last element
    private ListNode reverse(ListNode b, ListNode e) {
        ListNode pre = b.next;
        ListNode curr = pre.next;
        while (curr != null && curr != e) {
            pre.next = curr.next; // remove curr
            curr.next = b.next; //
            b.next = curr; // add to head
            curr = pre.next; // move curr to next
        }
        return pre;
    }
}
