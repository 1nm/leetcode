# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def minDepth(self, root):
        if root == None:
            return 0
        if root.left == None and root.right == None:
            return 1
        elif root.left != None and root.right == None:
            return 1 + self.minDepth(root.left)
        elif root.right != None and root.left == None:
            return 1 + self.minDepth(root.right)
        else:
            d1 = 1 + self.minDepth(root.left)
            d2 = 1 + self.minDepth(root.right)
            return d1 if d1 < d2 else d2