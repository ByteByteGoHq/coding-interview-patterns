function longestChainOfConsecutiveNumbersBruteForce(nums: number[]): number {
    if (nums.length === 0)
        return 0;
    let longestChain = 0;
    // Look for chains of consecutive numbers that start from each number.
    for (const num of nums) {
        let currentNum = num;
        let currentChain = 1;
        // Continue to find the next consecutive numbers in the chain.
        while (nums.includes(currentNum + 1)) {
            currentNum += 1;
            currentChain += 1;
        }
        longestChain = Math.max(longestChain, currentChain);
    }
    return longestChain;
}