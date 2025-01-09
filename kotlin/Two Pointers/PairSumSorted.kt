class PairSumSorted {

    fun pairSumSorted(nums: IntArray, target: Int): List<Int> {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val sum = nums[left] + nums[right]
            // If the sum is smaller, increment the left pointer, aiming
            // to increase the sum toward the target value.
            if (sum < target) {
                left++
            // If the sum is larger, decrement the right pointer, aiming
            // to decrease the sum toward the target value.
            } else if (sum > target) {
                right--
            // If the target pair is found, return its indexes.
            } else {
                return listOf(left, right)
            }
        }
        return emptyList()
    }
}