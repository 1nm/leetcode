public class AVLTree {
    TreeNode root;
    void insert(TreeNode node) {
	if (node.balanceFactor == 2) { // L
	    if (node.left != null && node.left.balanceFactor == 1) { // L
	    }
	}
    }

    class TreeNode {
	int val;
	int balanceFactor;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
	    this.val = val;
	    this.balanceFactor = 0;
	}
    }
}
