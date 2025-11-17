fn dfs(
    combination: &mut Vec<u32>,
    start_index: usize,
    nums: &[u32],
    target: u32,
    res: &mut Vec<Vec<u32>>,
) {
    // Termination condition: If the target is equal to 0, we found a combination that sums to 'k'
    if target == 0 {
        res.push(combination.clone());
        return;
    }

    // Explore all combinations starting from 'start_index'
    for i in start_index..nums.len() {
        let num = nums[i];

        // If current number is greater than the remaining target, no need to proceed (early stopping)
        if num > target {
            break; // this is where early stop occurs
                   // since nums are ordered no need to check the others (there are > target)
        }

        // Add the current number to create a new combination
        combination.push(num);
        // Recursively explore all paths that branch from this new combination
        dfs(combination, i, nums, target - num, res); // Safe subtraction: target >= num
                                                      // Backtrack by removing the number we just added
        combination.pop();
    }
}

fn combinations_of_sum_k(nums: &[u32], target: u32) -> Vec<Vec<u32>> {
    let mut sorted_nums = nums.to_vec();
    sorted_nums.sort_unstable(); // Sort the numbers to allow early stopping
    let mut combination = Vec::new();
    let mut res = Vec::new();
    dfs(&mut combination, 0, &sorted_nums, target, &mut res);
    res
}
