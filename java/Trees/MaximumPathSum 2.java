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

public class MaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode node) {
        // Base case: null nodes have no path sum.
        if (node == null) {
            return 0;
        }
        // Collect the maximum gain we can attain from the left and right 
        // subtrees, setting them to 0 if they're negative.
        int leftSum = Math.max(maxPathSumHelper(node.left), 0);
        int rightSum = Math.max(maxPathSumHelper(node.right), 0);
        // Update the overall maximum path sum if the current path sum is 
        // larger.
        maxSum = Math.max(maxSum, node.val + leftSum + rightSum);
        // Return the maximum sum of a single, continuous path with the 
        // current node as an endpoint.
        return node.val + Math.max(leftSum, rightSum);
    }
}
