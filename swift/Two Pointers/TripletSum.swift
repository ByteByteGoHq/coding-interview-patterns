func tripletSum(_ nums: [Int]) -> [[Int]] {
    var triplets = [[Int]]()
    let sortedNums = nums.sorted()
    for i in 0..<nums.count {
        // Optimization: triplets consisting of only positive numbers
        // will never sum to 0.

        if nums[i] > 0 {
            break
        }
        // To avoid duplicate triplets, skip 'a' if it's the same as
        // the previous number.
        if i > 0 && sortedNums[i] == sortedNums[i - 1] {
            continue
        }
        // Find all pairs that sum to a target of '-a' (-nums[i]).
        let pairs = pairSumSortedAllPairs(sortedNums, i + 1, -sortedNums[i])
        for pair in pairs {
            triplets.append([sortedNums[i]] + pair)
        }
    }
    return triplets
}

func pairSumSortedAllPairs(_ nums: [Int], _ start: Int, _ target: Int)
    -> [[Int]]
{
    var pairs = [[Int]]()
    var left = start
    var right = nums.count - 1
    while left < right {
        let sum = nums[left] + nums[right]
        if sum == target {
            pairs.append([nums[left], nums[right]])
            left += 1
            // To avoid duplicate '[b, c]' pairs, skip 'b' if it's the
            // same as the previous number.
            while left < right && nums[left] == nums[left - 1] {
                left += 1
            }
        } else if sum < target {
            left += 1
        } else {
            right -= 1
        }
    }
    return pairs
}
