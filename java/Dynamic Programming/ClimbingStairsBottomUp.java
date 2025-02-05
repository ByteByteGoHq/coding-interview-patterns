public class ClimbingStairsBottomUp {
    public int climbingStairsBottomUp(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        // Base cases.
        dp[1] = 1;
        dp[2] = 2;
        // Starting from step 3, calculate the number of ways to reach each 
        // step until the n-th step.
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
