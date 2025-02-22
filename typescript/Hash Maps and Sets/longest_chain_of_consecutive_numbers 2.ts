function longestChainOfConsecutiveNumbers(nums: number[]): number {
    if (nums.length === 0)
        return 0;
    const numSet = new Set(nums);
    let longestChain = 0;
    for (const num of numSet) {
        // If the current number is the smallest number in its chain, search for
        // the length of its chain.
        if (!numSet.has(num - 1)) {
            let currentNum = num;
            let currentChain = 1;
            // Continue to find the next consecutive numbers in the chain.
            while (numSet.has(currentNum + 1)) {
                currentNum += 1;
                currentChain += 1;
            }
            longestChain = Math.max(longestChain, currentChain);
        }
    }
    return longestChain;
}