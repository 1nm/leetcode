# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isBalanced(self, root):
        if root == None:
            return True
        else:
            dl = self.getDepth(root.left)
            dr = self.getDepth(root.right)
            if abs(dl - dr) > 1:
                return False
            else:
                return self.isBalanced(root.left) and self.isBalanced(root.right)

    def getDepth(self, root):
        if root == None:
            return 0
        elif root.left == None and root.right == None:
            return 1
        elif root.left != None and root.right == None:
            return 1 + self.getDepth(root.left)
        elif root.left == None and root.right != None:
            return 1 + self.getDepth(root.right)
        elif root.left != None and root.right != None:
            d1 = 1 + self.getDepth(root.left)
            d2 = 1 + self.getDepth(root.right)
            return d1 if d1 > d2 else d2