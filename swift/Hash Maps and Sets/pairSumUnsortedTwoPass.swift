func pairSumUnsortedTwoPass(_ nums: [Int], target: Int) -> [Int] {
    var numMap: [Int: Int] = [:]
    // First pass: Populate the dictionary with each number and its index
    for (index, num) in nums.enumerated() {
        numMap[num] = index
    }

    // Second pass: Check for each number's complement in the dictionary

    for (index, num) in nums.enumerated() {
        var complement = target - num
        if let complementCheck = numMap[complement], complementCheck != index {
            return [index, numMap[complement, default: 0]]
        }
    }

    return []
}
