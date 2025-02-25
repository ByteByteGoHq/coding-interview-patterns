import java.util.HashMap;
import java.util.Map;

public class MinCoinCombinationTopDown {
    public int minCoinCombinationTopDown(int[] coins, int target) {
        int res = topDownDp(coins, target, new HashMap<>());
        return res == Integer.MAX_VALUE ? -1 : res;
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
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            // Avoid negative targets.
            if (coin <= target) {
                // Calculate the minimum number of coins needed if we use
                // the current coin.
                int result = topDownDp(coins, target - coin, memo);
                if (result!= Integer.MAX_VALUE) {
                    minCoins = Math.min(minCoins, 1 + result);
                }
            }
        }
        memo.put(target, minCoins);
        return memo.get(target);
    }
}
