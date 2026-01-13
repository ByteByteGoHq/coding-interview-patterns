func longestChainOfConsecutiveNumbersBruteForce(_ nums: [Int]) -> Int {
    guard !nums.isEmpty else { return 0 }
    var longestChain = 0
    
    // Look for chains of consecutive numbers that start from each number.
    for num in nums {
        var currentNum = num
        var currentChain = 1
        
        while nums.contains(currentNum + 1) {
            currentNum += 1
            currentChain += 1
        }
        
        longestChain = max(longestChain, currentChain)
    }
    
    return longestChain
}
