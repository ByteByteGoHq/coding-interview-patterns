function longestSubstringWithUniqueCharsOptimized(s: string): number {
    let maxLen = 0;
    let prevIndexes: { [key: string]: number } = {};
    let left = 0, right = 0;
    while(right < s.length) {
        // If a previous index of the current character is present
        // in the current window, it's a duplicate character in the
        // window. 
        if (prevIndexes[s[right]] !== undefined 
            && prevIndexes[s[right]] >= left) {
            // Shrink the window to exclude the previous occurrence
            // of this character.
            left = prevIndexes[s[right]] + 1;
        }
        // Update 'maxLen' if the current window is larger.
        maxLen = Math.max(maxLen, right - left + 1);
        prevIndexes[s[right]] = right;
        // Expand the window.
        right++;
    }
    return maxLen;
}
