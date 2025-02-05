import java.util.Arrays;

public class MinCoinCombinationBottomUp {
    public int minCoinCombinationBottomUp(int[] coins, int target) {
        // The DP array will store the minimum number of coins needed for 
        // each amount. Set each element to a large number initially.
        int max = target + 1;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, max);
        // Base case: if the target is 0, then 0 coins are needed.
        dp[0] = 0;
        // Update the DP array for all target amounts greater than 0.
        for (int t = 1; t < target + 1; t++) {
            for (int coin : coins) {
                if (coin <= t) {
                    dp[t] = Math.min(dp[t], 1 + dp[t - coin]);
                }
            }
        }
        return dp[target] != max ? dp[target] : -1;
    }
}