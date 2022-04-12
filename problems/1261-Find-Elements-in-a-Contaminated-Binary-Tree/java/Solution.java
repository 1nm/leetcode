/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class FindElements {

  TreeNode root;

  public FindElements(TreeNode root) {
    this.root = root;
  }

  private boolean find(TreeNode root, int target, int curr) {
    if (target == curr)
      return true;
    if (root.left != null) {
      boolean foundInLeft = find(root.left, target, curr * 2 + 1);
      if (foundInLeft)
        return true;
    }
    if (root.right != null) {
      boolean foundInRight = find(root.right, target, curr * 2 + 2);
      if (foundInRight)
        return true;
    }
    return false;
  }

  public boolean find(int target) {
    return find(root, target, 0);
  }
}

/**
 * Your FindElements object will be instantiated and called as such: FindElements obj = new
 * FindElements(root); boolean param_1 = obj.find(target);
 */
