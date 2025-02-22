import java.util.ArrayList;
import java.util.List;

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

public class KthSmallestNumberInBSTRecursive {
    public int kthSmallestNumberInBSTRecursive(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();
        inorder(root, sortedList);
        return sortedList.get(k - 1);
    }

    // Inorder traversal function to attain a sorted list of nodes from the BST.
    private void inorder(TreeNode node, List<Integer> sortedList) {
        if (node == null) {
            return;
        }
        inorder(node.left, sortedList);
        sortedList.add(node.val);
        inorder(node.right, sortedList);
    }
}
