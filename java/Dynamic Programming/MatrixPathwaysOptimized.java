import java.util.Arrays;

public class MatrixPathwaysOptimized {
    public int matrixPathwaysOptimized(int m, int n) {
        // Initialize 'prevRow' as the DP values of row 0, which are all 1s.
        int[] prevRow = new int[n];
        Arrays.fill(prevRow, 1);
        // Iterate through the matrix starting from row 1.
        for (int r = 1; r < m; r++) {
            // Set the first cell of 'curr_row' to 1. This is done by
            // setting the entire row to 1.
            int[] currRow = new int[n];
            Arrays.fill(currRow, 1);
            for (int c = 1; c < n; c++) {
                // The number of unique paths to the current cell is the sum
                // of the paths from the cell above it ('prevRow[c]') and
                // the cell to the left ('currRow[c - 1]').
                currRow[c] = prevRow[c] + currRow[c - 1];
            }
            // Update 'prevRow' with 'currRow' values for the next
            // iteration.
            prevRow = currRow;
        }
        // The last element in 'prevRow' stores the result for the
        // bottom-right cell.
        return prevRow[n - 1];
    }
}
