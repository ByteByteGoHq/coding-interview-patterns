package common.twopointers.ispalindrome

class IsPalindromeValid {

    fun solution(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            // Skip non-alphanumeric characters from the left.
            while (left < right && !s[left].isLetterOrDigit()) {
                left++
            }
            // Skip non-alphanumeric characters from the right.
            while (left < right && !s[right].isLetterOrDigit()) {
                right--
            }
            // If the characters at the left and right pointers don't
            // match, the string is not a palindrome.
            if (s[left] != s[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }
}