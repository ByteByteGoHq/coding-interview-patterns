public class Solution 
{
    public int LargestContainerBruteForce(int[] heights) 
    {
        int n = heights.Length;
        int max_water = 0;
        // Find the maximum amount of water stored between all pairs of
        // lines.
        for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                int water = Math.Min(heights[i], heights[j]) * (j - i);
                max_water = Math.Max(max_water, water);
            }
        }

        return max_water;
    }
}