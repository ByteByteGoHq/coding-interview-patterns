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

public class InvertBinaryTreeRecursive {
    public TreeNode invertBinaryTreeRecursive(TreeNode root) {
        // Base case: If the node is null, there's nothing to invert.
        if (root == null) {
            return root;
        }
        // Swap the left and right subtrees of the current node.
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // Recursively invert the left and right subtrees.
        invertBinaryTreeRecursive(root.left);
        invertBinaryTreeRecursive(root.right);
        return root;
    }
}
