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

public class BalancedBinaryTreeValidation {
    public boolean balancedBinaryTreeValidation(TreeNode root) {
        return getHeightImbalance(root) != -1;
    }

    private int getHeightImbalance(TreeNode node) {
        // Base case: if the node is null, its height is 0.
        if (node == null) {
            return 0;
        }
        // Recursively get the height of the left and right subtrees. If
        // either subtree is imbalanced, propagate -1 up the tree.
        int leftHeight = getHeightImbalance(node.left);
        int rightHeight = getHeightImbalance(node.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        // If the current node's subtree is imbalanced
        // (height difference > 1), return -1.
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // Return the height of the current subtree.
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
