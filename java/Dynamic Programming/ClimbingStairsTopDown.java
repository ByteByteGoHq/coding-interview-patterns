import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsTopDown {
    Map<Integer, Integer> memo = new HashMap<>();

    public int climbingStairsTopDown(int n) {
        // Base cases: With a 1-step staircase, there's only one way to 
        // climb it. With a 2-step staircase, there are two ways to climb it.
        if (n <= 2) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        // The number of ways to climb to the n-th step is equal to the sum 
        // of the number  of ways to climb to step n - 1 and to n - 2.
        memo.put(n, climbingStairsTopDown(n - 1) + climbingStairsTopDown(n - 2));
        return memo.get(n);
    }
}
