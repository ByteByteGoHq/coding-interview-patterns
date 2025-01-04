package common.twopointers.tripletsum

class TripletSumBruteForce {

    fun solution(nums: List<Int>): List<List<Int>> {
        // Use a hash set to ensure we don't add duplicate triplets.
        val triplets = hashSetOf<List<Int>>()
        // Iterate through the indexes of all triplets. O(n^3)
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Sort the triplet before including it in the hash set.
                        val candidateList = mutableListOf(nums[i], nums[j], nums[k])
                        candidateList.sort()
                        triplets.add(candidateList)
                    }
                }
            }
        }
        return triplets.toList()
    }
}