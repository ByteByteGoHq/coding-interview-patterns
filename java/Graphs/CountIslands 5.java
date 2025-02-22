public class CountIslands {
    public int countIslands(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                // If a land cell is found, perform DFS to explore the full 
                // island, and include this island in our count.
                if (matrix[r][c] == 1) {
                    dfs(r, c, matrix);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, int[][] matrix) {
        // Mark the current land cell as visited.
        matrix[r][c] = -1;
        // Define direction vectors for up, down, left, and right.
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // Recursively call DFS on each neighboring land cell to continue 
        // exploring this island.
        for (int[] d : dirs) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (isWithinBounds(nextR, nextC, matrix) && matrix[nextR][nextC] == 1) {
                dfs(nextR, nextC, matrix);
            }
        }
    }

    private boolean isWithinBounds(int r, int c, int[][] matrix) {
        return 0 <= r && r < matrix.length && 0 <= c && c < matrix[0].length;
    }
}
