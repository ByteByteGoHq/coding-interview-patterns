pub fn combinations_of_sum_k(nums: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
    let mut result: Vec<Vec<i32>> = Vec::new();
    let mut combination: Vec<i32> = Vec::new();
    
    combinations_of_sum_k_impl(&mut combination, 0, &nums, target, &mut result);
    
    result
}

fn combinations_of_sum_k_impl(
    combination: &mut Vec<i32>,
    start_index: usize,
    nums: &Vec<i32>,
    target: i32,
    result: &mut Vec<Vec<i32>>
) {
    // Termination condition: If the target is equal to 0, we found a combination 
    // that sums to 'k'.
    if target == 0 {
        result.push(combination.clone());
        return;
    }
    
    // Termination condition: If the target is less than 0, no more valid 
    // combinations can be created by adding it to the current combination.
    if target < 0 {
        return;
    }
    
    // Starting from start_index, explore all combinations after adding nums[i].
    for i in start_index..nums.len() {
        // Add the current number to create a new combination.
        combination.push(nums[i]);
        
        // Recursively explore all paths that branch from this new combination.
        combinations_of_sum_k_impl(combination, i, nums, target - nums[i], result);
        
        // Backtrack by removing the number we just added.
        combination.pop();
    }
}