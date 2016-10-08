# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        p = q = head
        while p != None:
            while p.next != None and p.val == p.next.val:
                p = p.next
            q.next = p.next
            p = p.next
            q = p
        return head