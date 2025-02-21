public class MaximumSubarraySum {
    public int maximumSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Set the sum variables to Integer.MIN_VALUE to ensure negative
        // sums can be considered.
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        // Iterate through the array to find the maximum subarray sum.
        for (int num : nums) {
            // Either add the current number to the existing running sum, or
            // start a new subarray at the current number.
            currentSum = Math.max(currentSum + num, num);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
