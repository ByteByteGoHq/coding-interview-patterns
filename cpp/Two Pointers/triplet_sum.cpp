#include <algorithm>
#include <vector>

// Helper function to find all pairs that sum to a target in a sorted array
std::vector<std::vector<int>> pairSumSortedAllPairs(std::vector<int>& nums, int start, int target);

std::vector<std::vector<int>> tripletSum(std::vector<int>& nums) {
    std::vector<std::vector<int>> triplets;
    std::sort(nums.begin(), nums.end());
    for (int i = 0; i < nums.size(); i++) {
        // Optimization: triplets consisting of only positive numbers 
        // will never sum to 0.
        if (nums[i] > 0) {
            break;
        }
        // To avoid duplicate triplets, skip 'a' if it's the same as 
        // the previous number.        
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        // Find all pairs that sum to a target of '-a' (-nums[i]).
        std::vector<std::vector<int>> pairs = pairSumSortedAllPairs(nums, i + 1, -nums[i]);
        for (auto& pair : pairs) {
            triplets.push_back({nums[i], pair[0], pair[1]});
        }
    }
    return triplets;
}

std::vector<std::vector<int>> pairSumSortedAllPairs(std::vector<int>& nums, int start, int target) {
    std::vector<std::vector<int>> pairs;
    int left = start;
    int right = nums.size() - 1;
    while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) {
            pairs.push_back({nums[left], nums[right]});
            left++;
            // To avoid duplicate '[b, c]' pairs, skip 'b' if it's the 
            // same as the previous number.
            while (left < right && nums[left] == nums[left - 1]) {
                left++;
            }
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return pairs;
}