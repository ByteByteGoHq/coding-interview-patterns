fn pair_sum_sorted_brute_force(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let n = nums.len();

    for i in 0..n {
        for j in (i + 1)..n {
            if nums[i] + nums[j] == target {
                return vec![i as i32, j as i32];
            }
        }
    }
    vec![]
}
