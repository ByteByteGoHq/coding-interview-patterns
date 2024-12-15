package main

import (
	"sort"
)

func tripletSumBruteForce(nums []int) [][]int {
	n := len(nums)
	triplets := [][]int{}
	index := 0

	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			for k := j + 1; k < n; k++ {
				if nums[i]+nums[j]+nums[k] == 0 {
					triplet := []int{nums[i], nums[j], nums[k]}
					sort.Ints(triplet)
					triplets = append(triplets, triplet)
					index++
				}
			}
		}
	}

	return triplets
}
