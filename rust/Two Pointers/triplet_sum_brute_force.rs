use std::collections::HashSet;

pub fn triplet_sum_brute_force(nums: &[i32]) -> Vec<Vec<i32>> {
    let n = nums.len();
    let mut triplets: HashSet<Vec<i32>> = HashSet::new();

    for i in 0..n {
        for j in (i + 1)..n {
            for k in (j + 1)..n {
                if nums[i] + nums[j] + nums[k] == 0 {
                    let mut triplet = vec![nums[i], nums[j], nums[k]];
                    triplet.sort();
                    triplets.insert(triplet);
                }
            }
        }
    }

    triplets.into_iter().collect()
}
