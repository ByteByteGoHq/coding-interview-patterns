public class HammingWeightsOfIntegersDp {
    public int[] hammingWeightsOfIntegersDp(int n) {
        // Base case: the number of set bits in 0 is just 0. We set dp[0] to 
        // 0 by initializing the entire DP array to 0.
        int[] dp = new int[n + 1];
        for (int x = 0; x < n + 1; x++) {
            // 'dp[x]' is obtained using the result of 'dp[x >> 1]', plus 
            // the LSB of 'x'.
            dp[x] = dp[x >> 1] + (x & 1);
        }
        return dp;
    }
}
