class Pair : IComparable<Pair>
{
    public string Str { get; }
    public int Freq { get; }

    public Pair(string str, int freq)
    {
        Str = str;
        Freq = freq;
    }

    public int CompareTo(Pair other)
    {
        // Prioritize lexicographical order for strings with equal frequencies.
        if (this.Freq == other.Freq)
            return string.Compare(this.Str, other.Str, StringComparison.Ordinal);

        // Otherwise, prioritize strings with higher frequencies.
        return other.Freq - this.Freq;
    }
}

public class Solution
{
    public string[] KMostFrequentStringsMaxHeap(string[] strs, int k)
    {
        Dictionary<string, int> freqs = [];
        foreach (string str in strs)
            freqs[str] = freqs.GetValueOrDefault(str) + 1;

        // Create the max heap by adding all Pair objects.
        PriorityQueue<Pair, Pair> maxHeap = new();
        foreach ((string str, int freq) in freqs)
        {
            Pair pair = new Pair(str, freq);
            maxHeap.Enqueue(pair, pair);
        }

        // Pop the most frequent string off the heap 'k' times and return 
        // these 'k' most frequent strings.
        List<string> result = [];
        for (int i = 0; i < k && maxHeap.Count > 0; i++)
            result.Add(maxHeap.Dequeue().Str);

        return result.ToArray();
    }
}