pub fn pair_sum_sorted_brute_force(nums: &[i32], target: i32) -> Vec<usize> {
    let n = nums.len();

    for i in 0..n {
        for j in (i + 1)..n {
            if nums[i] + nums[j] == target {
                return vec![i, j];
            }
        }
    }

    vec![]
}
