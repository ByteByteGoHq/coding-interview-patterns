use std::collections::HashSet;

fn triplet_sum_brute_force(nums: Vec<i32>) -> Vec<Vec<i32>> {
    let n = nums.len();
    // Use a hash set to ensure we don't add duplicate triplets.
    let mut triplets = HashSet::new();

    // Iterate through the indexes of all triplets.
    for i in 0..n {
        for j in (i + 1)..n {
            for k in (j + 1)..n {
                if nums[i] + nums[j] + nums[k] == 0 {
                    // Sort the triplet before including it in the hash set.
                    let mut triplet = vec![nums[i], nums[j], nums[k]];
                    triplet.sort();
                    triplets.insert(triplet);
                }
            }
        }
    }

    triplets.into_iter().collect()
}
