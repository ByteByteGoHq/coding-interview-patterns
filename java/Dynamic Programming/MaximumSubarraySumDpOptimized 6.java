public class MaximumSubarraySumDpOptimized {
    public int maximumSubarraySumDpOptimized(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
