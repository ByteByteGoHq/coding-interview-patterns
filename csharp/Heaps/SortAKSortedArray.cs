public class Solution
{
    public int[] SortAKSortedArray(int[] nums, int k)
    {
        PriorityQueue<int, int> minHeap = new(Comparer<int>.Create((x, y) => x - y));

        // Populate a min-heap with the first k + 1 values in 'nums'.
        for (int i = 0; i < k + 1; i++)
            minHeap.Enqueue(nums[i], nums[i]);

        // Replace elements in the array with the minimum from the heap at each iteration.
        int insertIndx = 0;
        for (int i = k + 1; i < nums.Length; i++)
        {
            nums[insertIndx] = minHeap.Dequeue();
            insertIndx++;
            minHeap.Enqueue(nums[i], nums[i]);
        }

        // Pop the remaining elements from the heap to finish sorting the array.
        while (minHeap.Count > 0)
        {
            nums[insertIndx] = minHeap.Dequeue();
            insertIndx++;
        }

        return nums;
    }
}
