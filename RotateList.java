/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length ++;
            if (node.next == null) { // last node
                node.next = head;
                break;
            } else {
                node = node.next;
            }
        }
        ListNode newHead = head;
        int moves = length - (k % length);
        for (int i = 0; i < moves; ++ i) {
            newHead = newHead.next;
        }
        node = newHead;
        for (int i = 0; i < length - 1; ++ i) {
            node = node.next;
        }
        node.next = null;
        return newHead;
    }
}