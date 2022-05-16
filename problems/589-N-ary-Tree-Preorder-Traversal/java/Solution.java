/*
 * // Definition for a Node. class Node { public int val; public List<Node> children;
 * 
 * public Node() {}
 * 
 * public Node(int _val) { val = _val; }
 * 
 * public Node(int _val, List<Node> _children) { val = _val; children = _children; } };
 */

class Solution {
  private void visit(Node node, List<Integer> res) {
    if (node == null)
      return;
    res.add(node.val);
    if (node.children != null) {
      for (Node child : node.children) {
        visit(child, res);
      }
    }
  }

  public List<Integer> preorder(Node root) {
    List<Integer> res = new ArrayList<>();
    visit(root, res);
    return res;
  }
}
