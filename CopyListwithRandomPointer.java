/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode node = head;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode pre = dummyHead;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            pre.next = newNode;
            pre = newNode;
            map.put(node, newNode);
            node = node.next;
        }
        for (RandomListNode n : map.keySet()) {
            if (n.random != null) {
                RandomListNode mapped = map.get(n);
                mapped.random = map.get(n.random);
                map.put(n, mapped);
            }
        }
        return dummyHead.next;
    }
}
