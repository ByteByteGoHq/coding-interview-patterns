package common.twopointers.largestcontainer

import kotlin.math.max
import kotlin.math.min

class LargestContainerNaive {

    fun solution(heights: List<Int>): Int {
        var maxWater = 0
        // Find the maximum amount of water stored between all pairs of lines.
        for (i in heights.indices) {
            for (j in i + 1 until heights.size) {
                // Select minimum among them. Water can be contained depending on lower height.
                val width = min(heights[i], heights[j])
                val length = j - i
                // Rectangle formula.
                val water = width * length
                maxWater = max(maxWater, water)
            }
        }
        return maxWater
    }
}