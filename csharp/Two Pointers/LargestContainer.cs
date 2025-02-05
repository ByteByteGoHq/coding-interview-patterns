public partial class Solution 
{
    public int LargestContainer(int[] heights) 
    {
        int max_water = 0;
        int left = 0, right = heights.Length - 1;
        while (left < right) 
        {
            // Calculate the water contained between the current pair of
            // lines.
            int water = Math.Min(heights[left], heights[right]) * (right - left);
            max_water = Math.Max(max_water, water);
            // Move the pointers inward, always moving the pointer at the
            // shorter line. If both lines have the same height, move both
            // pointers inward.
            if (heights[left] < heights[right]) 
            {
                left++;
            } 
            else if (heights[left] > heights[right]) 
            {
                right--;
            } 
            else 
            {
                left++;
                right--;
            }
        }

        return max_water;
    }
}