import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Prerequisites {
    public boolean prerequisites(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegrees = new int[n];
        // Represent the graph as an adjacency list and record the in-
        // degree of each course.
        for (int[] edge : prerequisites) {
            int prerequisite = edge[0];
            int course = edge[1];
            graph.putIfAbsent(prerequisite, new ArrayList<>());
            graph.get(prerequisite).add(course);
            inDegrees[course]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        // Add all courses with an in-degree of 0 to the queue.
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int enrolledCourses = 0;
        // Perform topological sort.
        while (!queue.isEmpty()) {
            int node = queue.poll();
            enrolledCourses++;
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    inDegrees[neighbor]--;
                    // If the in-degree of a neighboring course becomes 0, add 
                    // it to the queue.
                    if (inDegrees[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        // Return true if we've successfully enrolled in all courses.
        return enrolledCourses == n;
    }
}
