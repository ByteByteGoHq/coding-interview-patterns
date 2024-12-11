func shiftZerosToTheEndNaive(_ nums: inout [Int]) {
    var temp = Array(repeating: 0, count: nums.count)
    var i = 0
    // Add all non-zero elements to the left of 'temp'.
    for num in nums {
        if num != 0 {
            temp[i] = num
            i += 1
        }
    }
    // Set 'nums' to 'temp'.
    for j in 0..<nums.count {
        nums[j] = temp[j]
    }
}