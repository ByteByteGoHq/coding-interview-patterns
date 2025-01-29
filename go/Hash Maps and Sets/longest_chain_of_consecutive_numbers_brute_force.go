package hashmapsandsets

func LongestChainOfConsecutiveNumbersBruteForce(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	longestChain := 0
	// Look for chains of consecutive numbers that start from each number.
	for _, num := range nums {
		currentNum := num
		currentChain := 1
		// Continue to find the next consecutive numbers in the chain.
		for contains(nums, currentNum+1) {
			currentNum++
			currentChain++
		}
		if currentChain > longestChain {
			longestChain = currentChain
		}
	}
	return longestChain
}

// In the Python code, the while loop checks (current_num +1) in nums.
// So the helper function 'contains' is needed.
func contains(nums []int, target int) bool {
	for _, n := range nums {
		if n == target {
			return true
		}
	}
	return false
}
