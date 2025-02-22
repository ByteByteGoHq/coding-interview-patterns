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

public class BinarySearchTreeValidation {
    public boolean binarySearchTreeValidation(TreeNode root) {
        // Start validation at the root node. The root node can contain any 
        // value, so set the initial lower and upper bounds to null.
        return isWithinBounds(root, null, null);
    }

    private boolean isWithinBounds(TreeNode node, Integer lowerBound, Integer upperBound) {
        // Base case: if the node is null, it satisfies the BST condition.
        if (node == null) {
            return true;
        }
        // If the current node's value is not within the valid bounds, this 
        // tree is not a valid BST.
        if (lowerBound != null && node.val <= lowerBound || upperBound != null && upperBound <= node.val) {
            return false;
        }
        // If the left subtree isn't a BST, this tree isn't a BST.
        if (!isWithinBounds(node.left, lowerBound, node.val)) {
            return false;
        }
        // Otherwise, return true if the right subtree is also a BST.
        return isWithinBounds(node.right, node.val, upperBound);
    }
}
