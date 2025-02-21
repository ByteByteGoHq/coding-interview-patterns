import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int size) {
        this.parent = new int[size];
        this.size = new int[size];
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
        }
        Arrays.fill(this.size, 1);
    }

    public boolean union(int x, int y) {
        int repX = find(x);
        int repY = find(y);
        if (repX != repY) {
            if (this.size[repX] > this.size[repY]) {
                this.parent[repY] = repX;
                this.size[repX] += this.size[repY];
            }
            else {
                this.parent[repX] = repY;
                this.size[repY] += this.size[repX];
            }
            // Return True if both groups were merged.
            return true;
        }
        // Return False if the points belong to the same group.
        return false; 
    }

    public int find(int x) {
        if (x == this.parent[x]) {
            return x;
        }
        this.parent[x] = find(this.parent[x]);
        return this.parent[x];
    }
}

public class ConnectTheDots {
    public int connectTheDots(int[][] points) {
        int n = points.length;
        // Create and populate a list of all possible edges.
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Manhattan distance.
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{cost, i, j});
            }
        }
        // Sort the edges by their cost in ascending order.
        Collections.sort(edges, (a, b) -> Integer.compare(a[0], b[0]));
        UnionFind uf = new UnionFind(n);
        int totalCost, edgesAdded;
        totalCost = edgesAdded = 0;
        // Use Kruskal's algorithm to create the MST and identify its minimum cost.
        for (int[] edge : edges) {
            int cost = edge[0];
            int p1 = edge[1];
            int p2 = edge[2];
            // If the points are not already connected (i.e. their representatives are
            // not the same), connect them, and add the cost to the total cost.
            if (uf.union(p1, p2)) {
                totalCost += cost;
                edgesAdded++;
                // If n - 1 edges have been added to the MST, the MST is complete.
                if (edgesAdded == n - 1) {
                    return totalCost;
                }
            }
        }
        return 0;
    }
}
