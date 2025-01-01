#include <algorithm> 
#include <set>       
#include <vector>

std::vector<std::vector<int>> tripletSumBruteForce(std::vector<int>& nums) {
    int n = nums.size();
    // Use a hash set to ensure we don't add duplicate triplets.
    std::set<std::vector<int>> triplets;
    // Iterate through the indexes of all triplets.
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    // Sort the triplet before including it in the 
                    // hash set.
                    std::vector<int> triplet = {nums[i], nums[j], nums[k]};
                    std::sort(triplet.begin(), triplet.end());
                    triplets.insert(triplet);
                }
            }
        }
    }
    return {triplets.begin(), triplets.end()};
}