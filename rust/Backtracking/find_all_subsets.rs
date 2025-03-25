pub fn find_all_subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
    let mut result: Vec<Vec<i32>> = Vec::new();
    let mut curr_subset: Vec<i32> = Vec::new();
    
    find_all_subsets_impl(0, &mut curr_subset, &nums, &mut result);
    
    result
}

fn find_all_subsets_impl(
    i: usize,
    curr_subset: &mut Vec<i32>,
    nums: &Vec<i32>,
    result: &mut Vec<Vec<i32>>
) {
    // Base case: if all elements have been considered, add the
    // current subset to the output.
    if i == nums.len() {
        result.push(curr_subset.clone());
        return;
    }
    
    // Include the current element and recursively explore all paths
    // that branch from this subset.
    curr_subset.push(nums[i]);
    find_all_subsets_impl(i + 1, curr_subset, nums, result);
    
    // Exclude the current element and recursively explore all paths
    // that branch from this subset.
    curr_subset.pop();
    find_all_subsets_impl(i + 1, curr_subset, nums, result);
}
