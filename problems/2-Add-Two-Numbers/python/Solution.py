# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        sum = l1.val + l2.val
        curr = head = ListNode(sum % 10)
        carry = sum / 10
        p1 = l1.next
        p2 = l2.next
        while p1 != None or p2 != None:
            sum = carry
            if p1 != None:
                sum += p1.val
                p1 = p1.next
            if p2 != None:
                sum += p2.val
                p2 = p2.next
            curr.next = ListNode(sum % 10)
            curr = curr.next
            carry = sum / 10
        if carry != 0:
            curr.next = ListNode(carry)
        return head