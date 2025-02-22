fn longest_substring_with_unique_chars(s: String) -> i32 {
    use std::collections::HashSet;

    let mut max_len = 0;
    let mut hash_set = HashSet::new();
    let mut left = 0;
    let mut right = 0;
    let s = s.as_bytes();

    while right < s.len() {
        // If we encounter a duplicate character in the window, shrink
        // the window until it's no longer a duplicate.
        while hash_set.contains(&s[right]) {
            hash_set.remove(&s[left]);
            left += 1;
        }
        // Once there are no more duplicates in the window, update
        // 'max_len' if the current window is larger.
        max_len = max_len.max(right - left + 1);
        hash_set.insert(s[right]);
        // Expand the window.
        right += 1;
    }

    max_len as i32
}
