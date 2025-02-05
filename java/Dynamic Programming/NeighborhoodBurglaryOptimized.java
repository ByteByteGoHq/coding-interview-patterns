public class NeighborhoodBurglaryOptimized {
    public int neighborhoodBurglaryOptimized(int[] houses) {
        if (houses == null || houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }
        // Initialize the variables with the base cases.
        int prevMaxProfit = Math.max(houses[0], houses[1]);
        int prevPrevMaxProfit = houses[0];

        for (int i = 2; i < houses.length; i++) {
            int currMaxProfit = Math.max(prevMaxProfit, houses[i] + prevPrevMaxProfit);
            // Update the values for the next iteration.
            prevPrevMaxProfit = prevMaxProfit;
            prevMaxProfit = currMaxProfit;
        }
        return prevMaxProfit;
    }
}
