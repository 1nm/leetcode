public class Solution {

    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int ret = head.val;
        int count = 1;
        ListNode node = head.next;
        while (node != null) {
            count++;
            int rand = (int) (Math.random() * count);
            if (rand == 0)
                ret = node.val;
            node = node.next;
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */