fn largest_container_brute_force(heights: Vec<i32>) -> i32 {
    let n = heights.len();
    let mut max_water = 0;

    // Find the maximum amount of water stored between all pairs of lines.
    for i in 0..n {
        for j in (i + 1)..n {
            let water = heights[i].min(heights[j]) * (j as i32 - i as i32);
            max_water = max_water.max(water);
        }
    }
    max_water
}
