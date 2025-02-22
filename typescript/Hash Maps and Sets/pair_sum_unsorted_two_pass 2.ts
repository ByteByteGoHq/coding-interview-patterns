function pairSumUnsortedTwoPass(nums: number[], target: number): number[] {
    const numMap: { [key: number]: number } = {};
    // First pass: Populate the hash map with each number and its 
    // index.
    for (let i = 0; i < nums.length; i++)
        numMap[nums[i]] = i;
    // Second pass: Check for each number's complement in the hash map.
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        if (numMap[complement] !== undefined && numMap[complement] !== i) 
            return [i, numMap[complement]];
    }
    return [];
}
