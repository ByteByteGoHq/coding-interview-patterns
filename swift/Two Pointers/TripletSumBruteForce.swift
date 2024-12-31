func tripletSumBruteForce(_ nums: [Int]) -> [[Int]] {
    let n = nums.count
    // Use a hash set to ensure we don't add duplicate triplets.
    var triplets = Set<[Int]>()
    // Iterate through the indexes of all triplets.
    for i in 0..<n {
        for j in i + 1..<n {
            for k in j + 1..<n {
                if nums[i] + nums[j] + nums[k] == 0 {
                    // Sort the triplet before including it in the 
                    // hash set.
                    let triplet = [nums[i], nums[j], nums[k]].sorted()
                    triplets.insert(triplet)
                }
            }
        }
    }
    return Array(triplets)
}