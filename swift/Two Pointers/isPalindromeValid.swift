func isPalindromeValid(_ s: String) -> Bool {
    let s = Array(s)
    var left = 0
    var right = s.count - 1

    while left < right {
        // Skip non-alphanumeric characters from the left.
        while left < right && !s[left].isLetter && !s[left].isNumber {
            left += 1
        }
        // Skip non-alphanumeric characters from the right.
        while left < right && !s[right].isLetter && !s[right].isNumber {
            right -= 1
        }
        // If the characters at the left and right pointers don't
        // match, the string is not a palindrome.
        if s[left] != s[right] {
            return false
        }
        left += 1
        right -= 1
    }
    return true
}