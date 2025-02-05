public partial class Solution 
{
    public int[] PairSumSortedBruteForce(int[] nums, int target) 
    {
        int n = nums.Length;
        for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (nums[i] + nums[j] == target) 
                {
                    return [i, j];
                }
            }
        }

        return [];
    }
}