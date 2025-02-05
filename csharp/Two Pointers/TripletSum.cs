public partial class Solution
{
    public IList<IList<int>> TripletSum(int[] nums) 
    {
        IList<IList<int>> triplets = [];
        Array.Sort(nums);
        for (int i = 0; i < nums.Length; i++) 
        {
            // Optimization: triplets consisting of only positive numbers
            // will never sum to 0.
            if (nums[i] > 0) 
            {
                break;
            }

            // To avoid duplicate triplets, skip 'a' if it's the same as
            // the previous number.
            if (i > 0 && nums[i] == nums[i - 1]) 
            {
                continue;
            }

            // Find all pairs that sum to a target of '-a' (-nums[i]).
            IList<IList<int>> pairs = PairSumSortedAllPairs(nums, i + 1, -nums[i]);
            foreach (var pair in pairs) 
            {
                triplets.Add([nums[i], pair[0], pair[1]]);
            }
        }

        return triplets;
    }

    public IList<IList<int>> PairSumSortedAllPairs(int[] nums, int start, int target) 
    {
        IList<IList<int>> pairs = [];
        int left = start, right = nums.Length - 1;
        while (left < right) 
        {
            int sum = nums[left] + nums[right];
            if (sum == target) 
            {
                pairs.Add([nums[left], nums[right]]);
                left++;
                // To avoid duplicate '[b, c]' pairs, skip 'b' if it's the
                // same as the previous number.
                while (left < right && nums[left] == nums[left - 1]) 
                {
                    left++;
                }
            }
            else if (sum < target) 
            {
                left++;
            } 
            else 
            {
                right--;
            }
        }

        return pairs;
    }
}