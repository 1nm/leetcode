/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p = head, q = head;
    // let p be n - 1 (since n is 1 based) steps ahead of q
    for (int i = 0; i < n - 1; i++) {
      p = p.next;
    }
    // move p to the last node, and q is the node to remove
    ListNode pre = q;
    while (p.next != null) {
      p = p.next;
      pre = q;
      q = q.next;
    }
    if (q == head)
      return head.next;
    pre.next = q.next;
    return head;
  }
}
