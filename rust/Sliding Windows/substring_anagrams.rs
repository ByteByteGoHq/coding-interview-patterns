fn substring_anagrams(s: String, t: String) -> i32 {
    let len_s = s.len();
    let len_t = t.len();
    if len_t > len_s {
        return 0;
    }
    let mut count = 0;
    let mut expected_freqs = vec![0; 26];
    let mut window_freqs = vec![0; 26];
    // Populate 'expected_freqs' with the characters in string 't'.
    for c in t.bytes() {
        expected_freqs[(c - b'a') as usize] += 1;
    }
    let mut left = 0;
    let mut right = 0;
    while right < len_s {
        // Add the character at the right pointer to 'window_freqs'
        // before sliding the window.
        window_freqs[(s.as_bytes()[right] - b'a') as usize] += 1;
        // If the window has reached the expected fixed length, we
        // advance the left pointer as well as the right pointer to
        // slide the window.
        if right - left + 1 == len_t {
            if window_freqs == expected_freqs {
                count += 1;
            }
            // Remove the character at the left pointer from
            // 'window_freqs' before advancing the left pointer.
            window_freqs[(s.as_bytes()[left] - b'a') as usize] -= 1;
            left += 1;
        }
        right += 1;
    }
    count
}
