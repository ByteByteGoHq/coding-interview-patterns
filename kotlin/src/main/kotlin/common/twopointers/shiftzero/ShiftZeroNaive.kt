package common.twopointers.shiftzero

class ShiftZeroNaive {

    fun solution(nums: IntArray) {
        val temp = IntArray(nums.size)
        var i = 0

        // Add all non-zero elements to the left of 'temp'.
        for (num in nums) {
            if (num != 0) {
                // Mark non-zero on tmp
                // Otherwise, skip this num
                temp[i] = num
                i++
            }
        }

        // Set 'nums' to 'temp'.
        for (j in temp.indices) {
            nums[j] = temp[j]
        }
    }
}