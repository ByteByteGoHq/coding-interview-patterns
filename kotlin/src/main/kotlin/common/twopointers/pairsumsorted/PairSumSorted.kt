package common.twopointers.pairsumsorted

class PairSumSorted {

    fun solution(nums: IntArray, target: Int): List<Int> {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val sum = nums[left] + nums[right]
            if (sum < target) {
                left++
            } else if (sum > target) {
                right--
            } else {
                return listOf(left, right)
            }
        }
        return emptyList()
    }
}