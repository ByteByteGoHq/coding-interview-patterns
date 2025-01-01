#include <algorithm> 
#include <vector>

int largestContainer(std::vector<int>& heights) {
    int maxWater = 0;
    int left = 0;
    int right = heights.size() - 1;
    while (left < right) {
        // Calculate the water contained between the current pair of 
        // lines. 
        int water = std::min(heights[left], heights[right]) * (right - left); 
        maxWater = std::max(maxWater, water);
        // Move the pointers inward, always moving the pointer at the 
        // shorter line. If both lines have the same height, move both 
        // pointers inward.
        if (heights[left] < heights[right]) {
            left++;
        } else if (heights[left] > heights[right]) {
            right--;
        } else {
            left++;
            right--;
        }
    }
    return maxWater;
}