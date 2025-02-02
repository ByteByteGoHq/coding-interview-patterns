function tripletSumBruteForce(nums: number[]): number[][] {
    let n = nums.length;
    // Use a hash set to ensure we don't add duplicate triplets.
    let triplets: Set<string> = new Set();
    // Iterate through the indexes of all triplets.
    for (let i = 0; i < n - 2; i++) {
        for (let j = i + 1; j < n - 1; j++) {
            for (let k = j + 1; k < n; k++) {
                if (nums[i] + nums[j] + nums[k] === 0) {
                    // Sort the triplet before including it in the hash set.
                    // [javascript] convert triplet array into a JSON string to use as a unqiue Set value.
                    let triplet = JSON.stringify([nums[i], nums[j], nums[k]].sort())
                    triplets.add(triplet)
                }
            }
        }
    }
    // [javascript] convert the Set back into an array of triplets.
    return Array.from(triplets).map((str) => JSON.parse(str));
}
