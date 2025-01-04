package common.twopointers.tripletsum

class TripletSum() {

    fun solution(nums: List<Int>): List<List<Int>> {
        val triplets = mutableListOf<List<Int>>()
        val sortedNums = nums.sorted()
        for (i in sortedNums.indices) {
            // Optimization: triplets consisting of only positive numbers
            // will never sum to 0.
            if (sortedNums[i] > 0) {
                break
            }
            // To avoid duplicate triplets, skip 'a' if it's the same as
            // the previous number.
            if (i > 0 && sortedNums[i] == sortedNums[i - 1]) {
                continue
            }
            // Find all pairs that sum to a target of '-a' (-nums[i]).
            var listOfPair = pairSumSortedAllPairs(sortedNums, i + 1, -1 * sortedNums[i])
            for (l in listOfPair) {
                triplets.add(listOf(sortedNums[i], l[0], l[1]))
            }
        }
        return triplets
    }

    private fun pairSumSortedAllPairs(nums: List<Int>, start: Int, target: Int): List<List<Int>> {
        val listOfPair = mutableListOf<List<Int>>()
        var left = start
        var right = nums.size - 1
        while (left < right) {
            val pairSum = nums[left] + nums[right]
            if (pairSum == target) {
                listOfPair.add(listOf(nums[left], nums[right]))
                left++
                right--
                // To avoid duplicate '[b, c]' pairs, skip 'b' if it's the same as the previous number.
                while (left < right && nums[left] == nums[left - 1]) {
                    left++
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--
                }
            } else if (pairSum < target) {
                left++
            } else {
                right--
            }
        }
        return listOfPair
    }
}
