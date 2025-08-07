pub fn find_all_permutations(nums: Vec<i32>) -> Vec<Vec<i32>> {
    let mut res: Vec<Vec<i32>> = Vec::new();
    let mut candidate: Vec<i32> = Vec::new();
    let mut used: std::collections::HashSet<i32> = std::collections::HashSet::new();
    
    backtrack(&nums, &mut candidate, &mut used, &mut res);
    
    res
}

fn backtrack(
    nums: &Vec<i32>,
    candidate: &mut Vec<i32>,
    used: &mut std::collections::HashSet<i32>,
    res: &mut Vec<Vec<i32>>
) {
    // If the current candidate is a complete permutation, add it to the result.
    if candidate.len() == nums.len() {
        res.push(candidate.clone());
        return;
    }
    
    for &num in nums {
        if !used.contains(&num) {
            // Add 'num' to the current permutation and mark it as used.
            candidate.push(num);
            used.insert(num);
            
            // Recursively explore all branches using the updated permutation candidate.
            backtrack(nums, candidate, used, res);
            
            // Backtrack by reversing the changes made.
            candidate.pop();
            used.remove(&num);
        }
    }
}
