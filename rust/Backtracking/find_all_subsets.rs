fn backtrack(i: usize, curr_subset: &mut Vec<i32>, nums: &[i32], res: &mut Vec<Vec<i32>>) {
    // base case : if all elements have been considered, add the current subset to res
    if i == nums.len() {
        res.push(curr_subset.clone()); // cannot push curr_subset (it is used afterward) so we push a clone of it
        return;
    }
    // include the current element and recursively explore all paths that branch from this subset
    curr_subset.push(nums[i]);
    backtrack(i + 1, curr_subset, nums, res);
    // exclude the current element and recursively  explore all paths that branch from this subset
    curr_subset.pop();
    backtrack(i + 1, curr_subset, nums, res);
}

fn find_all_subsets(nums: &[i32]) -> Vec<Vec<i32>> {
    let mut res = Vec::new();
    backtrack(0, &mut vec![], nums, &mut res);
    res
}
