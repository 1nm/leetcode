/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;
        while (curr != null) {
            ListNode pre = dummy;
            while (pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }
            ListNode temp = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = temp;
        }
        return dummy.next;
    }
}
