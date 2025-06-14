class Pair : IComparable<Pair>
{
    public string Str { get; }
    public int Freq { get; }

    public Pair(string str, int freq)
    {
        Str = str;
        Freq = freq;
    }

    // Since this is a min-heap comparator, we can use the same 
    // comparator as the one used in the max-heap, but reversing the 
    // inequality signs to invert the priority.
    public int CompareTo(Pair other)
    {
        if (this.Freq == other.Freq)
            return string.Compare(other.Str, this.Str, StringComparison.Ordinal);

        return this.Freq - other.Freq;
    }
}

public class Solution
{
    public string[] KMostFrequentStringsMinHeap(string[] strs, int k)
    {
        Dictionary<string, int> freqs = [];
        foreach (string str in strs)
            freqs[str] = freqs.GetValueOrDefault(str) + 1;

        PriorityQueue<Pair, Pair> minHeap = new();

        foreach ((string str, int freq) in freqs)
        {
            Pair pair = new Pair(str, freq);
            minHeap.Enqueue(pair, pair);

            // If heap size exceeds 'k', pop the lowest frequency string to 
            // ensure the heap only contains the 'k' most frequent words so far.
            if (minHeap.Count > k)
                minHeap.Dequeue();
        }

        // Return the 'k' most frequent strings by popping the remaining 'k' 
        // strings from the heap. Since we're using a min-heap, we need to 
        // reverse the result after popping the elements to ensure the most 
        // frequent strings are listed first.
        List<string> result = [];
        while (minHeap.Count > 0)
            result.Add(minHeap.Dequeue().Str);

        result.Reverse();
        return result.ToArray();
    }
}