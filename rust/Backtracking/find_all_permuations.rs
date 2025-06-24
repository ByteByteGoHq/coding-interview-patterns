fn backtrack(nums: &mut Vec<i32>, start: usize, res: &mut Vec<Vec<i32>>) {
    // if current candidate is a complete permutation add it to the result
    if start == nums.len() {
        res.push(nums.clone()); // unavoidable here unless we return Vec<&[i32]>
        return;
    }
    for i in start..nums.len() {
        nums.swap(start, i);
        backtrack(nums, start + 1, res);
        nums.swap(start, i); // backtrack
    }
}

fn find_all_permutations(nums: &[i32]) -> Vec<Vec<i32>> {
    let mut res = Vec::new();
    let mut nums = nums.to_vec();
    backtrack(&mut nums, 0, &mut res);
    res
}
