import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root != null) {
            LinkedList<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root);
            result.add(root.val);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                result.add(node.left == null ? null : node.left.val);
                result.add(node.right == null ? null : node.right.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return jsonify(result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> list = parse(data);
        if (list.size() == 0) {
            return null;
        }
        int index = 0, count = 0;
        TreeNode root = new TreeNode(list.get(0));
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int left = (count << 1) + 1;
            int right = (count << 1) + 2;
            if (left < list.size() && list.get(left) != null) {
                node.left = new TreeNode(list.get(left));
                q.add(node.left);
            }
            if (right < list.size() && list.get(right) != null) {
                node.right = new TreeNode(list.get(right));
                q.add(node.right);
            }
            count++;
        }
        return root;
    }

    private String jsonify(List<Integer> list) {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        for (int i = 0; i < list.size(); ++ i) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(list.get(i));
        }
        sb.append(']');
        return sb.toString();
    }

    private List<Integer> parse(String json) {
        List<Integer> result = new ArrayList<Integer>();
        String array = json.substring(1, json.length() - 1);
        if (array.length() == 0) {
            return result;
        }
        String[] splitted = array.split(",");
        for (int i = 0; i < splitted.length; ++ i) {
            Integer num = null;
            try {
                num = Integer.parseInt(splitted[i].trim());
            } catch (Exception e) {
                // ignore
            }
            result.add(num);
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
