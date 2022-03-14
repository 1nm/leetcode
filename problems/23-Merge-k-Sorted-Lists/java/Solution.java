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
        if (lists.length == 0)
            return null;
        Queue<ListNode> q = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
        for (int i = 0; i < lists.length; ++ i)
            if (lists[i] != null)
                q.add(lists[i]);
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;
            if (tail.next != null)
                q.add(tail.next);
        }
        return dummyHead.next;
    }
}
