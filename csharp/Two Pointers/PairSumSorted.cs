public class Solution 
{
    public int[] PairSumSorted(int[] nums, int target) 
    {
        int left = 0, right = nums.Length - 1;
        while (left < right) 
        {
            int sum = nums[left] + nums[right];
            // If the sum is smaller, increment the left pointer, aiming
            // to increase the sum toward the target value.
            if (sum < target) 
            {
                left++;
            }
            // If the sum is larger, decrement the right pointer, aiming
            // to decrease the sum toward the target value.
            else if (sum > target) 
            {
                right--;
            } 
            // If the target pair is found, return its indexes.
            else 
            {
                return [left, right];
            }
        }

        return [];
    }
}