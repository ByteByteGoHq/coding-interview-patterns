import java.util.Arrays;

public class Candies {
    public int candies(int[] ratings) {
        int n = ratings.length;
        // Ensure each child starts with 1 candy.
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        // First pass: for each child, ensure the child has more candies  
        // than their left-side neighbor if the current child's rating is 
        // higher.
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // Second pass: for each child, ensure the child has more candies 
        // than their right-side neighbor if the current child's rating is 
        // higher.
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // If the current child already has more candies than their 
                // right-side neighbor, keep the higher amount.
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        return Arrays.stream(candies).sum();
    }
}
