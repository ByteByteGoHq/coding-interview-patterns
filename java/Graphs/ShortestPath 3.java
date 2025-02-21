import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ShortestPath {
    public int[] shortestPath(int n, int[][] edges, int start) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        // Represent the graph as an adjacency list.
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, start}); // (distance, node)
        // Use Dijkstra's algorithm to find the shortest path between the start node
        // and all other nodes.
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currDist = curr[0];
            int currNode = curr[1];
            // If the current distance to this node is greater than the recorded
            // distance, we've already found the shortest distance to this node.
            if (currDist > distances[currNode]) {
                continue;
            }
            // Update the distances of the neighboring nodes.
            for (int[] edge : graph.get(currNode)) {
                int neighbor = edge[0];
                int weight = edge[1];
                int neighborDist = currDist + weight;
                // Only update the distance if we find a shorter path to this 
                // neighbor.
                if (neighborDist < distances[neighbor]) {
                    distances[neighbor] = neighborDist;
                    minHeap.offer(new int[]{neighborDist, neighbor});
                }
            }
        }
        // Convert all infinity values to -1, representing unreachable nodes.
        for (int i = 0; i < n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                distances[i] = -1;
            }
        }
        return distances;
    }
}
