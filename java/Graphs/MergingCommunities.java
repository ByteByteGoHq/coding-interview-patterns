import java.util.Arrays;

public class UnionFind {
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

    public void union(int x, int y) {
        int repX = find(x);
        int repY = find(y);
        // If 'repX' represents a larger community, connect
        // 'repY 's community to it.
        if (this.size[repX] > this.size[repY]) {
            this.parent[repY] = repX;
            this.size[repX] += this.size[repY];
        }
        // Otherwise, connect 'rep_x's community to 'rep_y'.
        else {
            this.parent[repX] = repY;
            this.size[repY] += this.size[repX];
        }
    }

    public int find(int x) {
        if (x == this.parent[x]) {
            return x;
        }
        // Path compression.
        this.parent[x] = find(this.parent[x]);
        return this.parent[x];
    }

    public int getSize(int x) {
        return this.size[find(x)];
    }
}

public class MergingCommunities {
    UnionFind uf;

    public MergingCommunities(int n) {
        this.uf = new UnionFind(n);
    }

    public void connect(int x, int y) {
        this.uf.union(x, y);
    }

    public int getCommunitySize(int x) {
        return this.uf.getSize(x);
    }
}
