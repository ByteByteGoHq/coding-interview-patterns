fn longest_substring_with_unique_chars_optimized(s: String) -> i32 {
    use std::collections::HashMap;

    let mut max_len = 0;
    let mut prev_indexes = HashMap::new();
    let mut left = 0;
    let mut right = 0;
    // Shadowing 's' by converting it to a byte array/slice.
    let s = s.as_bytes();

    while right < s.len() {
        // If a previous index of the current character is present
        // in the current window, it's a duplicate character in the
        // window. 
        if let Some(&prev_index) = prev_indexes.get(&s[right]) {
            // Shrink the window to exclude the previous occurrence
            // of this character.
            if prev_index >= left {
                left = prev_index + 1;
            }
        }
        // Update 'max_len' if the current window is larger.
        max_len = max_len.max(right - left + 1);
        prev_indexes.insert(s[right], right);
        // Expand the window.
        right += 1;
    }

    max_len as i32
}