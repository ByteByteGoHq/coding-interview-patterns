public partial class Solution 
{
    public string NextLexicographicalSequence(string s) 
    {
        char[] letters = s.ToCharArray();
        // Locate the pivot, which is the first character from the right that breaks 
        // non-increasing order. Start searching from the second-to-last position, 
        // since the last character is neither increasing nor decreasing.
        int pivot = letters.Length - 2;
        while (pivot >= 0 && letters[pivot] >= letters[pivot + 1]) 
        {
            pivot--;
        }
        // If pivot is not found, the string is already in its largest permutation. In 
        // this case, reverse the string to obtain the smallest permutation.
        if (pivot == -1) 
        {
            ReverseString(letters, 0, letters.Length - 1);
            return string.Join("", letters);        
        }
        // Find the rightmost successor to the pivot.
        int rightmost_successor = letters.Length - 1;
        while (letters[rightmost_successor] <= letters[pivot]) 
        {
            rightmost_successor--;
        }
        // Swap the rightmost successor with the pivot to increase the lexicographical 
        // order of the suffix.
        (letters[pivot], letters[rightmost_successor]) = (letters[rightmost_successor], letters[pivot]);
        // Reverse the suffix after the pivot to minimize its permutation.
        ReverseString(letters, pivot + 1, letters.Length - 1);
        return string.Join("", letters);
    }

    public void ReverseString(char[] s, int start, int end) 
    {
        while (start < end) 
        {
            (s[start], s[end]) = (s[end], s[start]);

            start++;
            end--;
        }
    }
}