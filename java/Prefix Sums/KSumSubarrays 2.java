public class KSumSubarrays {
    public int kSumSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        // Populate the prefix sum array, setting its first element to 0.
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        // Loop through all valid pairs of prefix sum values to find all 
        // subarrays that sum to 'k'.
        for (int j = 1; j < n + 1; j++) {
            for (int i = 1; i < j + 1; i++) {
                if (prefixSum[j] - prefixSum[i - 1] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
