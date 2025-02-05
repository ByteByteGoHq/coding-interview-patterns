public class LongestPalindromeInAString {
    public String longestPalindromeInAString(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int startIndex = 0;
        // Base case: a single character is always a palindrome.
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // Base case: a substring of length two is a palindrome if both
        // characters are the same.
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
                startIndex = i;
            }
        }
        // Find palindromic substrings of length 3 or greater.
        for (int substringLen = 3; substringLen < n + 1; substringLen++) {
            // Iterate through each substring of length 'substringLen'.
            for (int i = 0; i < n - substringLen + 1; i++) {
                int j = i + substringLen - 1;
                // If the first and last characters are the same, and the
                // inner substring is a palindrome, then the current
                // substring is a palindrome.
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLen = substringLen;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }
}
