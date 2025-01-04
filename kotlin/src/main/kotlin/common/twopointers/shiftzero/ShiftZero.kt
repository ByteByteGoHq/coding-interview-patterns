package common.twopointers.shiftzero

class ShiftZero {

    fun solution(nums: IntArray) {
        var left = 0
        for (right in nums.indices) {
            if (nums[right] != 0) {
                // Swap element
                nums[left] = nums[right].also { nums[right] = nums[left] }
                left++
            }
        }
    }

    fun solution2(nums: IntArray) {
        // Start 2 pointers at the start
        var writer = 0
        var reader = 0

        // Perform read, write on writer index in case non-zero
        // Otherwise, let reader skip
        while (reader < nums.size) {
            if (nums[reader] != 0) {
                nums[writer++] = nums[reader]
            }
            reader++
        }

        // Tail filling zero
        while (writer < nums.size) {
            nums[writer++] = 0
        }
    }
}