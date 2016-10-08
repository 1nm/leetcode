# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isSymmetric(self, root):
        if root == None:
            return True
        else:
            return self.isSymmetric2(root.left, root.right)
    def isSymmetric2(self, a, b):
        if a == None and b == None:
            return True
        elif a != None and b != None:
            return a.val == b.val and self.isSymmetric2(a.left, b.right) and self.isSymmetric2(a.right, b.left)
        else:
            return False