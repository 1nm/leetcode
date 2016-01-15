/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend || istart > iend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        // find root in in order, divide and conquer left sub tree and right sub tree
        int rindex = -1;
        for (int i = istart; i <= iend; ++ i) {
            if (inorder[i] == root.val) {
                rindex = i;
                break;
            }
        }
        if (rindex == -1) {
            return null;
        }
        // left children
        int numberOfLeftChildren = rindex - istart;
        int numberOfRightChildren = iend - rindex;
        root.left = build(preorder, pstart + 1, pstart + numberOfLeftChildren, inorder, istart, rindex - 1);
        root.right = build(preorder, pend - numberOfRightChildren + 1, pend, inorder, rindex + 1, iend);
        return root;
    }
}
