function geometricSequenceTriplets(nums: number[], r: number): number {
    const leftMap: { [key: number]: number } = {};
    const rightMap: { [key: number]: number } = {};
    let count = 0;
    // Populate 'rightMap' with the frequency of each element in the array.
    for (const x of nums)
        rightMap[x] = (rightMap[x] ?? 0) + 1;
    // Search for geometric triplets that have x as the center.
    for (const x of nums) {
        // Decrement the frequency of x in rightMap since x is now being
        // processed and is no longer to the right.
        rightMap[x] -= 1;
        if (x % r === 0)
            count += (leftMap[x / r] ?? 0) * (rightMap[x * r] ?? 0);
        // Increment the frequency of x in leftMap since it'll be a part of the
        // left side of the array once we iterate to the next value of x.
        leftMap[x] = (leftMap[x] ?? 0) + 1;
    }
    return count;
}