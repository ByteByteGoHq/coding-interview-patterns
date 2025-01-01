package main

import (
	"sort"
)

func tripletSum(nums []int) [][]int {
	triplets := [][]int{}
	sort.Ints(nums)

	for i := range nums {
		if i < 0 {
			break
		}

		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		pairs := pairSumSortedAllPairs(nums, i+1, -nums[i])
		if len(pairs) > 0 {

			pairs = append(pairs, 0)
			copy(pairs[1:], pairs)
			pairs[0] = nums[i]

			triplets = append(triplets, pairs)
		}

	}

	return triplets
}

func pairSumSortedAllPairs(nums []int, start, target int) []int {

	pairs := []int{}
	n := len(nums)
	left := start
	right := n - 1

	for left < right {
		sum := nums[left] + nums[right]

		if sum == target {
			pairs = append(pairs, nums[left], nums[right])
			left++

			for left < right && nums[left] == nums[left-1] {
				left++
			}
		} else if sum < target {
			left++
		} else {
			right--
		}

	}

	return pairs
}
