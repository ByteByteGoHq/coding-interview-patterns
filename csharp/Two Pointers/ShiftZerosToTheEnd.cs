public class Solution 
{
    public void ShiftZerosToTheEnd(int[] nums) 
    {
        // The 'left' pointer is used to position non-zero elements.
        int left = 0;
        // Iterate through the array using a 'right' pointer to locate non-zero
        // elements.
        for (int right = 0; right < nums.Length; right++) 
        {
            if (nums[right] != 0) 
            {
                (nums[right], nums[left]) = (nums[left], nums[right]);
                // Increment 'left' since it now points to a position already occupied
                // by a non-zero element.
                left++;
            }
        }
    }
}