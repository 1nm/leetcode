# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def removeNthFromEnd(self, head, n):
        p = q = head
        for i in xrange(0, n):
            if q == None:
                return head
            q = q.next
        if q == None:
            return head.next
        else:
            q = q.next
            while q != None:
                p = p.next
                q = q.next
            p.next = p.next.next
            return head
            
        