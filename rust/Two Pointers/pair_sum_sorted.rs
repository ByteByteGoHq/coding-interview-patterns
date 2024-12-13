pub fn pair_sum_sorted(nums: &[i32], target: i32) -> Vec<usize> {
    let mut left = 0;
    let mut right = nums.len() - 1;

    while left < right {
        let sum = nums[left] + nums[right];
        if sum < target {
            left += 1;
        } else if sum > target {
            right -= 1;
        } else {
            return vec![left, right];
        }
    }

    vec![]
}
