/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    Stack<TreeNode> stack;
    TreeNode current;

    public BSTIterator(TreeNode root) {
        this.current = root;
        stack = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(current == null && stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        int val = 0;
        while (!(current == null && stack.isEmpty())) {
            if (current != null) {
                this.stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                val = current.val;
                current = current.right;
                break;
            }
        }
        return val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */