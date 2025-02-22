function longestUniformSubstringAfterReplacements(s: string, k: number): number {
    const freqs: { [key: string]: number } = {};
    let highestFreq = 0, maxLen = 0;
    let left = 0, right = 0;
    while (right < s.length) {
        // Update the frequency of the character at the right pointer 
        // and the highest frequency for the current window.
        freqs[s[right]] = (freqs[s[right]] || 0) + 1;
        highestFreq = Math.max(highestFreq, freqs[s[right]]);
        // Calculate replacements needed for the current window.
        const numCharsToReplace = (right - left + 1) - highestFreq;
        // Slide the window if the number of replacements needed exceeds 
        // 'k'. The right pointer always gets advanced, so we just need 
        // to advance 'left'.
        if (numCharsToReplace > k) {
            // Remove the character at the left pointer from the hash map 
            // before advancing the left pointer.
            freqs[s[left]]--;
            left++;
        }
        // Since the length of the current window increases or stays the 
        // same, assign  the length of the current window to 'maxLen'.
        maxLen = right - left + 1;
        // Expand the window.
        right++;
    }
    return maxLen;
}