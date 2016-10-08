/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, curr = head;
        boolean delete = false;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val || delete) {
                if (curr.next != null && curr.val == curr.next.val) {
                    delete = true;
                } else {
                    delete = false;
                }
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}