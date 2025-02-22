import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class BinaryTreeColumns {
    public class Pair {
        TreeNode node;
        int column;
        public Pair(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public List<List<Integer>> binaryTreeColumns(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        int leftmostColumn, rightmostColumn;
        leftmostColumn = rightmostColumn = 0;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int column = pair.column;
            if (node != null) {
                // Add the current node's value to its corresponding list in the hash 
                // map.
                List<Integer> columnList = columnMap.getOrDefault(column, new ArrayList<>());
                columnList.add(node.val);
                columnMap.put(column, columnList);
                leftmostColumn = Math.min(leftmostColumn, column);
                rightmostColumn = Math.max(rightmostColumn, column);
                // Add the current node's children to the queue with their respective
                // column ids.
                queue.offer(new Pair(node.left, column - 1));
                queue.offer(new Pair(node.right, column + 1));
            }
        }
        // Construct the output list by collecting values from each column in the hash   
        // map in the correct order.
        List<List<Integer>> res = new ArrayList<>();
        for (int i = leftmostColumn; i <= rightmostColumn; i++) {
            List<Integer> column = columnMap.get(i);
            res.add(column);
        }
        return res;
    }
}
