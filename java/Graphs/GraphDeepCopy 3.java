import java.util.HashMap;
import java.util.Map;

import DS.GraphNode;

/*
    // Definition of GraphNode:
    class GraphNode {
        public int val;
        public List<GraphNode> neighbors;
        public MultiLevelListNode(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }
 */

public class GraphDeepCopy {
    public GraphNode graphDeepCopy(GraphNode node) {
        if (node == null) {
            return null;
        }
        Map<GraphNode, GraphNode> cloneMap = new HashMap<>();
        return dfs(node, cloneMap);
    }

    private GraphNode dfs(GraphNode node, Map<GraphNode, GraphNode> cloneMap) {
        // If this node was already cloned, then return this previously  
        // cloned node.
        if (cloneMap.containsKey(node)) {
            return cloneMap.get(node);
        }
        // Clone the current node.
        GraphNode clonedNode = new GraphNode(node.val);
        // Store the current clone to ensure it doesn't need to be created 
        // again in future DFS calls.
        cloneMap.put(node, clonedNode);
        // Iterate through the neighbors of the current node to connect  
        // their clones to the current cloned node.
        for (GraphNode neighbor : node.neighbors) {
            GraphNode clonedNeighbor = dfs(neighbor, cloneMap);
            clonedNode.neighbors.add(clonedNeighbor);
        }
        return clonedNode;
    }
}
