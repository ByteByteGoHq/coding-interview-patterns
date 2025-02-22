function substringAnagrams(s: string, t: string): number {
    const lenS = s.length, lenT = t.length;
    if (lenT > lenS) 
        return 0;
    let count = 0;
    const expectedFreqs = new Array(26).fill(0);
    const windowFreqs = new Array(26).fill(0);
    // Populate 'expected_freqs' with the characters in string 't'.
    for (const c of t)
        expectedFreqs[c.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    let left = 0, right = 0;
    while (right < lenS) {
        // Add the character at the right pointer to 'window_freqs' 
        // before sliding the window.
        windowFreqs[s[right].charCodeAt(0) - 'a'.charCodeAt(0)]++;
        // If the window has reached the expected fixed length, we 
        // advance the left pointer as well as the right pointer to 
        // slide the window.
        if (right - left + 1 === lenT) {
            if (windowFreqs.every((val, i) => val === expectedFreqs[i]))
                count++;
            // Remove the character at the left pointer from 
            // 'window_freqs' before advancing the left pointer.
            windowFreqs[s[left].charCodeAt(0) - 'a'.charCodeAt(0)]--;
            left++;
        }
        right++;
    }
    return count;
}
