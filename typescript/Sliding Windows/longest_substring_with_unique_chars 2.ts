function longestSubstringWithUniqueChars(s: string): number {
    let maxLen = 0;
    let hashSet: Set<string> = new Set();
    let left = 0, right = 0;
    while(right < s.length) {
        // If we encounter a duplicate character in the window, shrink 
        // the window until it's no longer a duplicate.
        while(hashSet.has(s[right])){
            hashSet.delete(s[left]);
            left++;
        }
        // Once there are no more duplicates in the window, update
        // 'maxLen' if the current window is larger.
        maxLen = Math.max(maxLen, right - left + 1);
        hashSet.add(s[right]);
        // Expand the window.
        right++;
    }
    return maxLen;
}
