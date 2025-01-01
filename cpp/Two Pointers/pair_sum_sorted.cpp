#include <vector>

std::vector<int> pairSumSorted(std::vector<int>& nums, int target) {
    int left = 0;
    int right = nums.size() - 1;
    while (left < right) {
        int sum = nums[left] + nums[right];
        // If the sum is smaller, increment the left pointer, aiming
        // to increase the sum toward the target value.
        if (sum < target) {
            left++;
        // If the sum is larger, decrement the right pointer, aiming
        // to decrease the sum toward the target value.
        } else if (sum > target) {
            right--;
        // If the target pair is found, return its indexes.
        } else {
            return {left, right};
        }
    }
    // If no valid pair is found, return an empty vector. 
    return {};
}