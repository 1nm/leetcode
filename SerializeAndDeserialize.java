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
        return create(list, 0);
    }

    private TreeNode create(List<Integer> list, int i) {
        TreeNode node = new TreeNode(list.get(i));
        int left = (i << 1) + 1;
        int right = (i << 1) + 2;
        // has left child
        if (left < list.size() && list.get(left) != null) {
            i ++;
            node.left = create(list, i);
        }
        // has right child
        if (right < list.size() && list.get(right) != null) {
            i ++;
            node.right = create(list, i);
        }
        return node;
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
