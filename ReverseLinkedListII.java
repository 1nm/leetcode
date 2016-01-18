/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        if (m == 1) {
            ListNode pre = null;
            ListNode curr = head;
            for (int i = 0; i < n; ++ i) {
                ListNodex next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            if (curr != null) {
                head.next = curr;
            }
            return pre;
        } else {
            ListNode node = head;
            for (int i = 1; i < m - 1; ++ i) {
                node = node.next;
            }
            node.next = reverseBetween(node.next, 1, n - m + 1);
            return head;
        }
    }
}
