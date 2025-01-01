#include <cctype>
#include <string>

bool isPalindromeValid(std::string s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
        // Skip non-alphanumeric characters from the left.
        while (left < right && !std::isalnum(s[left])) {
            left++;
        }
        // Skip non-alphanumeric characters from the right.
        while (left < right && !std::isalnum(s[right])) {
            right--;
        }
        // If the characters at the left and right pointers don't
        // match, the string is not a palindrome.  
        if (s[left] != s[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}