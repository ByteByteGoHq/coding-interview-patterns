public class LongestPalindromeInAStringExpanding {
    public String longestPalindromeInAStringExpanding(String s) {
        int n = s.length();
        int start, maxLen;
        start = maxLen = 0;
        for (int center = 0; center < n; center++) {
            // Check for odd-length palindromes.
            int oddStart, oddLength;
            int[] oddResult = expandPalindrome(center, center, s);
            oddStart = oddResult[0];
            oddLength = oddResult[1];
            if (oddLength > maxLen) {
                start = oddStart;
                maxLen = oddLength;
            }
            // Check for even-length palindromes.
            if (center < n - 1 && s.charAt(center) == s.charAt(center + 1)) {
                int evenStart, evenLength;
                int[] evenResult = expandPalindrome(center, center + 1, s);
                evenStart = evenResult[0];
                evenLength = evenResult[1];
                if (evenLength > maxLen) {
                    start = evenStart;
                    maxLen = evenLength;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    // Expands outward from the center of a base case to identify the start 
    // index and length of the longest palindrome that extends from this 
    // base case.
    private int[] expandPalindrome(int left, int right, String s) {
        while (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
            left--;
            right++;
        }
        return new int[]{left, right - left + 1};
    }
}
