import java.util.Stack;

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

public class KthSmallestNumberInBSTIterative {
    public int kthSmallestNumberInBSTIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            // Move to the leftmost node and add nodes to the stack as we go so they 
            // can be processed in future iterations.
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // Pop the top node from the stack to process it, and decrement 'k'.
            node = stack.pop();
            k--;
            // If we have processed 'k' nodes, return the value of the 'k'th smallest 
            // node.
            if (k == 0) {
                return node.val;
            }
            // Move to the right subtree.
            node = node.right;
        }
        return -1;
    }
}
