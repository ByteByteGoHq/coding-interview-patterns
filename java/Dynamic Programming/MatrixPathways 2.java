import java.util.Arrays;

public class MatrixPathways {
    public int matrixPathways(int m, int n) {
        // Base cases: Set all cells in row 0 and column 0 to 1. We can
        // do this by initializing all cells in the DP table to 1.
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 1);
        }
        // Fill in the rest of the DP table.
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                // Paths to current cell = paths from above + paths from 
                // left.
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
