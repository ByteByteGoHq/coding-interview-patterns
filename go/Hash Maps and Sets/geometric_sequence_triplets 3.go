func geometricSequenceTriplets(nums []int, r int) int {
	// Use 'map' to ensure the default value of 0 is returned when
	// accessing a key that doesn’t exist in the hash map. This effectively sets
	// the default frequency of all elements to 0.
	leftMap := make(map[int]int)
	rightMap := make(map[int]int)
	count := 0
	// Populate 'rightMap' with the frequency of each element in the array.
	for _, x := range nums {
		rightMap[x]++
	}
	// Search for geometric triplets that have x as the center.
	for _, x := range nums {
		// Decrement the frequency of x in 'rightMap' since x is now being
		// processed and is no longer to the right.
		rightMap[x]--
		if x%r == 0 {
			count += leftMap[x/r] * rightMap[x*r]
		}
		// Increment the frequency of x in 'leftMap' since it'll be a part of the
		// left side of the array once we iterate to the next value of x.
		leftMap[x]++
	}
	return count
}
