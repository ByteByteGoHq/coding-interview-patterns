#include <vector>

void shiftZerosToTheEndNaive(std::vector<int>& nums) {
    std::vector<int> temp(nums.size(), 0);
    int i = 0;
    // Add all non-zero elements to the left of 'temp'.
    for (int num : nums) {
        if (num != 0) {
            temp[i] = num;
            i++;
        }
    }
    // Set 'nums' to 'temp'.    
    for (int j = 0; j < nums.size(); j++) {
        nums[j] = temp[j];
    }
}