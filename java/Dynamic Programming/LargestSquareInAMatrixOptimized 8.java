public class LargestSquareInAMatrixOptimized {
    public int largestSquareInAMatrixOptimized(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prevRow = new int[n];
        int maxLen = 0;
        // Iterate through the matrix.
        for (int i = 0; i < m; i++) {
            int[] currRow = new int[n];
            for (int j = 0; j < n; j++) {
                // Base cases: if we’re in row 0 or column 0, the largest square ending
                // here has a length of 1. This can be set by using the value in the
                // input matrix.
                if (i == 0 || j == 0) {
                    currRow[j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 1) {
                        // currRow[j] = 1 + min(left, top-left, top)
                        currRow[j] = 1 + Math.min(currRow[j - 1], Math.min(prevRow[j - 1], prevRow[j]));
                    }
                }
                maxLen = Math.max(maxLen, currRow[j]);
            }
            // Update 'prevRow' with 'currRow' values for the next iteration.
            prevRow = currRow;
        }
        return maxLen * maxLen;
    }
}
