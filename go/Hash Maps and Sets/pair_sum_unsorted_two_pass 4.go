func pairSumUnsortedTwoPass(nums []int, target int) []int {
	numMap := make(map[int]int)
	// First pass: Populate the hash map with each number and its index.
	for i, num := range nums {
		numMap[num] = i
	}
	// Second pass: Check for each number's complement in the hash map.
	for i, num := range nums {
		complement := target - num
		if idx, ok := numMap[complement]; ok && idx != i {
			return []int{i, idx}
		}
	}
	return nil
}
