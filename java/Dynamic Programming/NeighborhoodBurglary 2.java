public class NeighborhoodBurglary {
    public int neighborhoodBurglary(int[] houses) {
        // Handle the cases when the array is less than the size of 2 to
        // avoid out-of-bounds errors when assigning the base case values.
        if (houses == null || houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }
        int[] dp = new int[houses.length];
        // Base case: when there's only one house, rob that house.
        dp[0] = houses[0];
        // Base case: when there are two houses, rob the one with the most
        // money.
        dp[1] = Math.max(houses[0], houses[1]);
        // Fill in the rest of the DP array.
        for (int i = 2; i < houses.length; i++) {
            // 'dp[i]' = max(profit if we skip house 'i', profit if we rob
            // house 'i').
            dp[i] = Math.max(dp[i - 1], houses[i] + dp[i - 2]);
        }
        return dp[houses.length - 1];
    }
}
