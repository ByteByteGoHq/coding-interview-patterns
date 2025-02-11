public class Solution 
{
    public bool IsPalindromeValid(string s) 
    {
        int left = 0, right = s.Length - 1;
        while (left < right) 
        {
            // Skip non-alphanumeric characters from the left.
            while (left < right && !char.IsLetterOrDigit(s[left])) 
            {
                left++;
            }
            
            // Skip non-alphanumeric characters from the right.
            while (left < right && !char.IsLetterOrDigit(s[right])) 
            {
                right--;
            }

            // If the characters at the left and right pointers don't
            // match, the string is not a palindrome.
            if (s[left] != s[right]) 
            {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}