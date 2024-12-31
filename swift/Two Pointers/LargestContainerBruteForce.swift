func largestContainerBruteForce(_ heights: [Int]) -> Int {
    let n = heights.count
    var maxWater = 0
    // Find the maximum amount of water stored between all pairs of
    // lines.
    for i in 0..<n {
        for j in i + 1..<n {
            let water = min(heights[i], heights[j]) * (j - 1)
            maxWater = max(maxWater, water)
        }
    }
    return maxWater
}