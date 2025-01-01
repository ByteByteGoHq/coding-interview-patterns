#include <algorithm>
#include <vector>

int largestContainerBruteForce(std::vector<int>& heights) {
    int n = heights.size();
    int maxWater = 0;
    // Find the maximum amount of water stored between all pairs of 
    // lines. 
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int water = std::min(heights[i], heights[j]) * (j - i);
            maxWater = std::max(maxWater, water);
        }
    }
    return maxWater;
}