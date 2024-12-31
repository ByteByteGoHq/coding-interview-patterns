func largestContainer(_ heights: [Int]) -> Int {
    var maxWater = 0
    var left = 0
    var right = heights.count - 1
    while left < right {
        // Calculate the water contained between the current pair of 
        // lines.
        let water = min(heights[left], heights[right]) * (right - left)
        maxWater = max(maxWater, water)
        // Move the pointers inward, always moving the pointer at the 
        // shorter line. If both lines have the same height, move both 
        // pointers inward.
        if heights[left] < heights[right] {
            left += 1
        } else if heights[left] > heights[right] {
            right -= 1
        } else {
            left += 1
            right -= 1
        }
    }
    return maxWater
}