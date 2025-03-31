pub fn find_all_subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
    let mut res: Vec<Vec<i32>> = Vec::new();
    let mut curr_subset: Vec<i32> = Vec::new();
    
    backtrack(0, &mut curr_subset, &nums, &mut res);
    
    res
}

fn backtrack(
    i: usize,
    curr_subset: &mut Vec<i32>,
    nums: &Vec<i32>,
    res: &mut Vec<Vec<i32>>
) {
    // Base case: if all elements have been considered, add the
    // current subset to the output.
    if i == nums.len() {
        res.push(curr_subset.clone());
        return;
    }
    
    // Include the current element and recursively explore all paths
    // that branch from this subset.
    curr_subset.push(nums[i]);
    backtrack(i + 1, curr_subset, nums, res);
    
    // Exclude the current element and recursively explore all paths
    // that branch from this subset.
    curr_subset.pop();
    backtrack(i + 1, curr_subset, nums, res);
}
