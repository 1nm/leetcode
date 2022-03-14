/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        int length = count(head);
        if (length == 0) {
            return true;
        }
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < length / 2; ++ i) {
            q = q.next;
        }
        q = reverse(q);
        for (int i = 0; i < length / 2; ++ i) {
            if (!((p == null && q == null) || (p != null && q != null && p.val == q.val))) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
    
    private int count(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode prev = null;
        while (p != null) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }
}