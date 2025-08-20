use std::collections::HashMap;

fn geometric_sequence_triplets(nums: Vec<i32>, r: i32) -> i32 {
    // Use HashMap to track frequencies, with default value of 0
    let mut left_map: HashMap<i32, i32> = HashMap::new();
    let mut right_map: HashMap<i32, i32> = HashMap::new();
    let mut count = 0;

    // Populate 'right_map' with the frequency of each element in the array
    for x in &nums {
        *right_map.entry(*x).or_insert(0) += 1;
    }

    // Search for geometric triplets that have x as the center
    for x in nums {
        // Decrement the frequency of x in 'right_map' since x is now being
        // processed and is no longer to the right
        *right_map.get_mut(&x).unwrap() -= 1;

        if x % r == 0 {
            let left_val = *left_map.get(&(x / r)).unwrap_or(&0);
            let right_val = *right_map.get(&(x * r)).unwrap_or(&0);
            count += left_val * right_val;
        }

        // Increment the frequency of x in 'left_map' since it'll be a part of the
        // left side of the array once we iterate to the next value of x
        *left_map.entry(x).or_insert(0) += 1;
    }

    count
}
