import java.util.HashMap;
import java.util.Map;

public class MinCoinCombinationTopDown {
    int max;

    public int minCoinCombinationTopDown(int[] coins, int target) {
        max = target + 1;
        int res = topDownDp(coins, target, new HashMap<>());
        return res == max ? -1 : res;
    }

    private int topDownDp(int[] coins, int target, Map<Integer, Integer> memo) {
        // Base case: if the target is 0, then 0 coins are needed to reach
        // it.
        if (target == 0) {
            return 0;
        }
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        // Initialize 'minCoins' to a large number.
        int minCoins = max;
        for (int coin : coins) {
            // Avoid negative targets.
            if (coin <= target) {
                // Calculate the minimum number of coins needed if we use
                // the current coin.
                minCoins = Math.min(minCoins, 1 + topDownDp(coins, target - coin, memo));
            }
        }
        memo.put(target, minCoins);
        return memo.get(target);
    }
}
