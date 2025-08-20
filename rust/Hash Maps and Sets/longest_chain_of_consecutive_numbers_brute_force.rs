fn longest_chain_of_consecutive_numbers_brute_force(nums: Vec<i32>) -> i32 {
    if nums.is_empty() {
        return 0;
    }

    let mut longest_chain = 0;

    // Look for chains of consecutive numbers that start from each number
    for num in &nums {
        let mut current_num = *num;
        let mut current_chain = 1;

        // Continue to find the next consecutive numbers in the chain
        while nums.contains(&(current_num + 1)) {
            current_num += 1;
            current_chain += 1;
        }

        longest_chain = longest_chain.max(current_chain);
    }

    longest_chain
}
