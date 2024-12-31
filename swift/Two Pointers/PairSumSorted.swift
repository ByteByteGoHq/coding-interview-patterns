func pairSumSorted(_ nums: [Int], _ target: Int) -> [Int] {
    var left = 0
    var right = nums.count - 1
    while left < right {
        let sum = nums[left] + nums[right]
        // If the sum is smaller, increment the left pointer, aiming
        // to increase the sum toward the target value.
        if sum < target {
            left += 1
        }
        // If the sum is larger, decrement the right pointer, aiming
        // to decrease the sum toward the target value.
        else if sum > target {
            right -= 1
        }
        // If the target pair is found, return its indexes.
        else {
            return [left, right]
        }
    }
    return []
}