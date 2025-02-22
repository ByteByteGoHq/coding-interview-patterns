public class KnapsackOptimized {
    public int knapsackOptimized(int cap, int[] weights, int[] values) {
        int n = values.length;
        // Initialize 'prevRow' as the DP values of the row below the
        // current row.
        int[] prevRow = new int[cap + 1];
        for (int i = n - 1; i >= 0; i--) {
            // Set the first cell of the 'currRow' to 0 to set the base
            // case for this row. This is done by initializing the entire
            // row to 0.
            int[] currRow = new int[cap + 1];
            for (int c = 1; c < cap + 1; c++) {
                // If item 'i' fits in the current knapsack capacity, the
                // maximum value at 'currRow[c]' is the largest of either:
                // 1. The maximum value if we include item 'i'.
                // 2. The maximum value if we exclude item 'i'.
                if (weights[i] <= c) {
                    currRow[c] = Math.max(values[i] + prevRow[c - weights[i]], prevRow[c]);
                }
                // If item 'i' doesn't fit, we exclude it.
                else {
                    currRow[c] = prevRow[c];
                }
            }
            // Set 'prevRow' to 'currRow' values for the next iteration.
            prevRow = currRow;
        }
        return prevRow[cap];
    }
}
