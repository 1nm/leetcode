/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode head = null;
    public ListNode sortList(ListNode head) {
        // use merge sort
        this.head = head;
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length ++;
            node = node.next;
        }
        return sort(length);
    }

    private ListNode sort(int length) {
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            ListNode node = this.head;
            this.head = this.head.next;
            node.next = null;
            return node;
        }
        ListNode left = sort(length / 2);
        ListNode right = sort(length - length / 2);
        return merge(left, right);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while (head1 != null || head2 != null) {
            int val1 = head1 == null ? Integer.MAX_VALUE : head1.val;
            int val2 = head2 == null ? Integer.MAX_VALUE : head2.val;
            if (val1 < val2) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
