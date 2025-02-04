func pairSumUnsorted(nums []int, target int) []int {
	hashmap := make(map[int]int)
	for i, x := range nums {
		complement := target - x
		if idx, exists := hashmap[complement]; exists {
			return []int{idx, i}
		}
		hashmap[x] = i
	}
	return nil
}
