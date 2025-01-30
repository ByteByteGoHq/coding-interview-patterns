func longestChainOfConsecutiveNumbers(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	numSet := make(map[int]bool)
	for _, num := range nums {
		numSet[num] = true
	}
	longestChain := 0
	for num := range numSet {
		// If the current number is the smallest number in its chain, search for
		// the length of its chain.
		if !numSet[num-1] {
			currentNum := num
			currentChain := 1
			// Continue to find the next consecutive numbers in the chain.
			for numSet[currentNum+1] {
				currentNum++
				currentChain++
			}
			if currentChain > longestChain {
				longestChain = currentChain
			}
		}
	}
	return longestChain
}
