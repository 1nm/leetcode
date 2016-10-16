public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    private int sum(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null) {
            if (isLeft) return 1; else return 0;
        }
        int s = 0;
        if (node.left != null) s += sum(node.left, true);
        if (node.right != null) s += sum(node.right, false);
        return s;
    }
}
