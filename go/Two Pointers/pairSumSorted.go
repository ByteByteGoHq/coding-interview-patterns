package main

func pairSumSorted(nums []int, target int) []int {
	n := len(nums)
	left, right := 0, n-1

	for left < right {
		sum := nums[left] + nums[right]
		if sum < target {
			left++
		} else if sum > target {
			right--
		} else {
			return []int{left, right}
		}
	}

	return []int{}
}
