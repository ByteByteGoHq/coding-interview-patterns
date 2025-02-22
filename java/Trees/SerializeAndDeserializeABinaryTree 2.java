import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import DS.TreeNode;

/*
    // Definition of TreeNode:
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
 */

public class SerializeAndDeserializeABinaryTree {
    public String serialize(TreeNode root) {
        // Perform a preorder traversal to add node values to a list, then convert the
        // list to a string.
        StringBuilder serializedList = new StringBuilder();
        preorderSerialize(root, serializedList);
        return serializedList.toString();
    }

    // Helper function to perform serialization through preorder traversal.
    private void preorderSerialize(TreeNode node, StringBuilder serializedList) {
        // Base case: mark null nodes as '#'.
        if (node == null) {
            serializedList.append("#").append(",");
            return;
        }
        // Preorder traversal processes the current node first, then the left and right
        // children.
        serializedList.append(node.val).append(",");
        preorderSerialize(node.left, serializedList);
        preorderSerialize(node.right, serializedList);
    }

    public TreeNode deserialize(String data) {
        // Obtain the node values by splitting the string using the comma delimiter.
        Queue<String> nodeValues = new LinkedList<>();
        nodeValues.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodeValues);
    }

    // Helper function to construct the tree using preorder traversal.
    private TreeNode buildTree(Queue<String> values) {
        String val = values.poll();
        // Base case: '#' indicates a null node.
        if (val.equals("#")) {
            return null;
        }
        // Use preorder traversal processes the current node first, then the left and 
        // right children.
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(values);
        node.right = buildTree(values);
        return node;
    }
}
