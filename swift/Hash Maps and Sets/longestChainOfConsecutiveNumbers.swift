func longestChainOfConsecutiveNumbers(_ nums: [Int]) -> Int {
    guard !nums.isEmpty else {
        return 0
    }
    
    var numSet = Set(nums)
    var longestChain = 0
    
    for num in numSet {
        // If the current number is the smallest number in its chain, search for
        // the length of its chain.
        if !numSet.contains(num - 1) {
            var currentNum = num
            var currentChain = 1
            // Continue to find the next consecutive numbers in the chain.
            while numSet.contains(currentNum + 1) {
                currentNum += 1
                currentChain += 1
            }
            longestChain = max(longestChain, currentChain)
        }
    }
    
    return longestChain
}
