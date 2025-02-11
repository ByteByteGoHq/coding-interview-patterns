public class Solution
{
    public void ShiftZerosToTheEndNaive(int[] nums) 
    {
        int[] temp = new int[nums.Length];
        int i = 0;
        // Add all non-zero elements to the left of 'temp'.
        foreach (int num in nums) 
        {
            if (num != 0)
            {
                temp[i] = num;
                i++;
            }
        }

        // Set 'nums' to 'temp'.
        for (int j = 0; j < nums.Length; j++) 
        {
            nums[j] = temp[j];
        }
    }
}