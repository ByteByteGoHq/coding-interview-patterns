import java.util.HashMap;
import java.util.Map;

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

public class BuildBinaryTree {
    int preorderIndex = 0;
    Map<Integer, Integer> inorderIndexesMap = new HashMap<>();
    
    public TreeNode buildBinaryTree(int[] preorder, int[] inorder) {
        // Populate the hash map with the inorder values and their indexes.
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexesMap.put(inorder[i], i);
        }
        // Build the tree and return its root node.
        return buildSubtree(0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildSubtree(int left, int right, int[] preorder, int[] inorder) {
        // Base case: if no elements are in this range, return None.
        if (left > right) {
            return null;
        }
        int val = preorder[preorderIndex];
        // Set 'inorderIndex' to the index of the same value pointed at by
        // 'preorderIndex'.
        int inorderIndex = inorderIndexesMap.get(val);
        TreeNode node = new TreeNode(val);
        // Advance 'preorderIndex' so it points to the value of the next
        // node to be created.
        preorderIndex++;
        // Build the left and right subtrees and connect them to the current
        // node.
        node.left = buildSubtree(left, inorderIndex - 1, preorder, inorder);
        node.right = buildSubtree(inorderIndex + 1, right, preorder, inorder);
        return node;
    }
}
