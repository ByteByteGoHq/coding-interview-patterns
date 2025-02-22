public class MaximumSubarraySumDp {
    public int maximumSubarraySumDp(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        // Base case: the maximum subarray sum of an array with just one
        // element is that element.
        dp[0] = nums[0];
        int maxSum = dp[0];
        // Populate the rest of the DP array.
        for (int i = 1; i < n; i++) {
            // Determine the maximum subarray sum ending at the current
            // index.
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
