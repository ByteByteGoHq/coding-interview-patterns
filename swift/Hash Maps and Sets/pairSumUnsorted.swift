func pairSumUnsorted(nums: [Int], target: Int) -> [Int] {
    var dictionary: [Int: Int] = [:]
    
    for (index, num) in nums.enumerated() {
        if dictionary[target - num] != nil {
            return [dictionary[target - num, default: 0], index]
        }
        dictionary[num] = index
    }
    
    return []
}


