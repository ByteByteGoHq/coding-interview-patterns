function pairSumUnsorted(nums: number[], target: number): number[] {
    const hashMap: { [key: number]: number } = {};
    for (let i = 0; i < nums.length; i++) {
        if (hashMap[target - nums[i]] !== undefined)
            return [hashMap[target - nums[i]], i];
        hashMap[nums[i]] = i;
    }
    return [];
}
