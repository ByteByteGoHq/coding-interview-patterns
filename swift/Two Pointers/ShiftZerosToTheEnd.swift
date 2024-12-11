func shiftZerosToTheEnd( _ nums: inout [Int]) {
    // The 'left' pointer is used to position non-zero elements.
    var left = 0
    // Iterate through the array using a 'right' pointer to locate non-zero 
    // elements.
    for right in 0..<nums.count {
        if nums[right] != 0 {
            nums.swapAt(right, left)
            // Increment 'left' since it now points to a position already occupied 
            // by a non-zero element.
            left += 1
        }
    }
}