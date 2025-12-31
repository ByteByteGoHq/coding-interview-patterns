func geometricSequenceTriplets(_ nums: [Int], _ r: Int) -> Int {
    // Use 'dictionary[T,default:T]' to ensure the default value of 0 is returned when
    // accessing a key that doesn’t exist in the hash map. This effectively sets
    // the default frequency of all elements to 0.

    var leftMap: [Int: Int] = [:]
    var rightMap: [Int: Int] = [:]
    var count = 0

    // Populate 'right_map' with the frequency of each element in the array.
    for x in nums {
        rightMap[x, default: 0] += 1
    }

    // Search for geometric triplets that have x as the center.
    for x in nums {
        // Decrement the frequency of x in 'right_map' since x is now being
        // processed and is no longer to the right.
        rightMap[x, default: 0] -= 1
        if x % r == 0 {
            count += leftMap[x / r, default: 0] * rightMap[x * r, default: 0]
        }

        // Increment the frequency of x in 'left_map' since it'll be a part of the
        // left side of the array once we iterate to the next value of x.
        leftMap[x, default: 0] += 1
    }

    return count

}
