package common.twopointers.largestcontainer

import kotlin.math.max
import kotlin.math.min

class LargestContainer {

    fun solution(heights: List<Int>): Int {
        var maxWater = 0
        var left = 0
        var right = heights.size - 1
        while (left < right) {
            // Select minimum among them. Water can be contained depending on lower height.
            val width = min(heights[left], heights[right])
            val length = right - left
            // Rectangle formula.
            // Calculate the water contained between the current pair of lines.
            val water = width * length
            maxWater = max(maxWater, water)

            // Move the pointers inward, always moving the pointer at the shorter line.
            // Otherwise, just move the right side.
            if (heights[left] < heights[right]) {
                left++
            } else {
                right--
            }
        }
        return maxWater
    }
}