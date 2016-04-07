/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                @Override
                public int compareTo(ListNode o) {
                    return this.val - o.val;
                }
            });
        for (int i = 0; i < lists.length; ++ i)
            q.add(lists[i]);
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;
            if (tail != null)
                q.add(tail);
        }
        return dummyHead.next;
    }
}
