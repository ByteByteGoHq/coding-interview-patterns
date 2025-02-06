public class HammingWeightsOfIntegers {
    public int[] hammingWeightsOfIntegers(int n) {
        int[] res = new int[n + 1];
        for (int x = 0; x < n + 1; x++) {
            res[x] = countSetBits(x);
        }
        return res;
    }

    private int countSetBits(int x) {
        int count = 0;
        // Count each set bit of 'x' until 'x' equals 0.
        while (x > 0) {
            // Increment the count if the LSB is 1.
            count += x & 1;
            // Right shift 'x' to shift the next bit to the LSB position.
            x >>= 1;
        }
        return count;
    }
}
