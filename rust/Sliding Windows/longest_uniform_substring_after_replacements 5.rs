fn longest_uniform_substring_after_replacements(s: String, k: i32) -> i32 {
    use std::collections::HashMap;

    let mut freqs = HashMap::new();
    let mut highest_freq = 0;
    let mut max_len = 0;
    let mut left = 0;
    let mut right = 0;
    let s = s.as_bytes();

    while right < s.len() {
        // Update the frequency of the character at the right pointer
        // and the highest frequency for the current window.
        *freqs.entry(s[right]).or_insert(0) += 1;
        highest_freq = highest_freq.max(*freqs.get(&s[right]).unwrap());
        // Calculate replacements needed for the current window.
        let num_chars_to_replace = ((right - left + 1) as i32) - highest_freq;
        // Slide the window if the number of replacements needed exceeds
        // 'k'. The right pointer always gets advanced, so we just need
        // to advance 'left'.
        if num_chars_to_replace > k {
            // Remove the character at the left pointer from the hash map
            // before advancing the left pointer.
            *freqs.get_mut(&s[left]).unwrap() -= 1;
            left += 1;
        }
        // Since the length of the current window increases or stays the
        // same, assign  the length of the current window to 'max_len'.
        max_len = max_len.max(right - left + 1);
        // Expand the window.
        right += 1;
    }

    max_len as i32
}
