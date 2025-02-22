import java.util.ArrayDeque;
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

public class WidestBinaryTreeLevel {
    public class Pair {
        TreeNode node;
        int index;
        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widestBinaryTreeLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0)); // Stores (node, index) pairs.
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Set the 'leftmostIndex' to the index of the first node in 
            // this level. Start 'rightmostIndex' at the same point as 
            // 'leftmostIndex' and update it as we traverse the level, 
            // eventually positioning it at the last node.
            int leftmostIndex = queue.peek().index;
            int rightmostIndex = leftmostIndex;
            // Process all nodes at the current level.
            for (int j = 0; j < levelSize; j++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int i = pair.index;
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * i + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * i + 2));
                }
                rightmostIndex = i;
            }
            maxWidth = Math.max(maxWidth, rightmostIndex - leftmostIndex + 1);
        }
        return maxWidth;
    }
}
