public class Solution 
{
    public IList<IList<int>> TripletSumBruteForce(int[] nums) 
    {
        int n = nums.Length;
        // Use a hash set to ensure we don't add duplicate triplets.
        HashSet<Tuple<int, int, int>> triplets = [];
        // Iterate through the indexes of all triplets.
        for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                for (int k = j + 1; k < n; k++) 
                {
                    if (nums[i] + nums[j] + nums[k] == 0) 
                    {
                        // Sort the triplet before including it in the
                        // hash set.
                        int[] triplet = [nums[i], nums[j], nums[k]];
                        Array.Sort(triplet);
                        triplets.Add(new Tuple<int, int, int>(triplet[0], triplet[1], triplet[2]));
                    }
                }
            }
        }

        IList<IList<int>> result = [];
        foreach (var triplet in triplets) 
        {
            result.Add([triplet.Item1, triplet.Item2, triplet.Item3]);
        }

        return result;
    }
}