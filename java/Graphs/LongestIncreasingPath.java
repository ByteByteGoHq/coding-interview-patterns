public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        // Find the longest increasing path starting at each cell. The
        // maximum of these is equal to the overall longest increasing
        // path.
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                res = Math.max(res, dfs(r, c, matrix, memo));
            }
        }
        return res;
    }

    private int dfs(int r, int c, int[][] matrix, int[][] memo) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        int maxPath = 1;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // The longest path starting at the current cell is equal to the
        // longest path of its larger neighboring cells, plus 1.
        for (int[] d : dirs) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (isWithinBounds(nextR, nextC, matrix) && matrix[nextR][nextC] > matrix[r][c]) {
                maxPath = Math.max(maxPath, 1 + dfs(nextR, nextC, matrix, memo));
            }
        }
        memo[r][c] = maxPath;
        return maxPath;
    }

    private boolean isWithinBounds(int r, int c, int[][] matrix) {
        return 0 <= r && r < matrix.length && 0 <= c && c < matrix[0].length;
    }
}
