# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def levelOrderBottom(self, root):
        if root == None:
            return []
        else:
            s = []
            q = collections.deque([(root, 0)])
            while len(q) != 0:
                head = q.popleft()
                node = head[0]
                level = head[1]
                if len(s) == level:
                    s.append([node.val])
                else:
                    s[level].append(node.val)
                if node.left != None:
                    q.append((node.left, level + 1))
                if node.right != None:
                    q.append((node.right, level + 1))
            s.reverse()
            return s