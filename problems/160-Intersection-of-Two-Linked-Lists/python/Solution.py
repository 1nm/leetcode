# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param two ListNodes
    # @return the intersected ListNode
    def getIntersectionNode(self, headA, headB):
        pa = headA
        pb = headB
        loopA = True
        loopB = True
        while True:
            if (pa == pb):
                return pa
            else:
                if (pa != None):
                    pa = pa.next
                else:
                    if (loopA):
                        loopA = False
                        pa = headB
                if (pb != None):
                    pb = pb.next
                else:
                    if (loopB):
                        loopB = False
                        pb = headA