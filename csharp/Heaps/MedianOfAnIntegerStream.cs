public class MedianOfAnIntegerStream
{
    PriorityQueue<int, int> leftHalf;   // max-heap
    PriorityQueue<int, int> rightHalf;  // min-heap

    public MedianOfAnIntegerStream()
    {
        leftHalf = new(Comparer<int>.Create((x, y) => y - x));
        rightHalf = new(Comparer<int>.Create((x, y) => x - y));
    }

    public void Add(int num)
    {
        // If 'num' is less than or equal to the max of 'leftHalf', it 
        // belongs to the left half.
        if (leftHalf.Count == 0 || num <= leftHalf.Peek())
        {
            leftHalf.Enqueue(num, num);

            // Rebalance the heaps if the size of the 'leftHalf' 
            // exceeds the size of the 'rightHalf' by more than one.
            if (leftHalf.Count > rightHalf.Count + 1)
            {
                int leftTop = leftHalf.Dequeue();
                rightHalf.Enqueue(leftTop, leftTop);
            }
        }
        // Otherwise, it belongs to the right half.
        else
        {
            rightHalf.Enqueue(num, num);

            // Rebalance the heaps if 'rightHalf' is larger than 'leftHalf'.
            if (leftHalf.Count < rightHalf.Count)
            {
                int rightTop = rightHalf.Dequeue();
                leftHalf.Enqueue(rightTop, rightTop);
            }
        }
    }

    public double GetMedian()
    {
        if (leftHalf.Count == rightHalf.Count)
            return (leftHalf.Peek() + rightHalf.Peek()) / 2.0;

        return leftHalf.Peek();
    }
}
