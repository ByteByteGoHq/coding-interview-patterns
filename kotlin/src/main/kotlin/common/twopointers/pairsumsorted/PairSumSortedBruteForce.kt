package common.twopointers.pairsumsorted

class PairSumSortedBruteForce {

    fun solution(nums: IntArray, target: Int): List<Int> {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return listOf(i, j)
                }
            }
        }
        return emptyList()
    }
}