import java.util.HashMap;
import java.util.Map;

public class KSumSubarraysOptimized {
    public int kSumSubarraysOptimized(int[] nums, int k) {
        int count = 0;
        // Initialize the map with 0 to handle subarrays that sum to 'k' 
        // from the start of the array.
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int currPrefixSum = 0;
        for (int num : nums) {
            // Update the running prefix sum by adding the current number.
            currPrefixSum += num;
            // If a subarray with sum 'k' exists, increment 'count' by the 
            // number of times it has been found.
            if (prefixSumMap.containsKey(currPrefixSum - k)) {
                count += prefixSumMap.get(currPrefixSum - k);
            }
            // Update the frequency of 'curr_prefix_sum' in the hash map.
            int freq = prefixSumMap.getOrDefault(currPrefixSum, 0);
            prefixSumMap.put(currPrefixSum, freq + 1);
        }
        return count;
    }

}
