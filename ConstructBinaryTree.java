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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (istart > iend || pstart > pend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pend]);

        int rindex = -1;
        // search for root in in order
        for (int i = istart; i <= iend; ++ i) {
            if (inorder[i] == root.val) {
                rindex = i;
                break;
            }
        }

        if (rindex == -1) {
            return null;
        }
        // found root index
        // number of left children is rindex - istart
        int numberOfLeftChildren = rindex - istart;
        // number of right children is iend - rindex
        int numberOfRightChildren = iend - rindex;

        root.left = build(inorder, istart, rindex - 1, postorder, pstart, pstart + numberOfLeftChildren - 1);
        root.right = build(inorder, rindex + 1, iend, postorder, pend - numberOfRightChildren, pend - 1);
        return root;
    }
}
