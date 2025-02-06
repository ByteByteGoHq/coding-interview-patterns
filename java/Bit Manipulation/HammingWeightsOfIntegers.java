import java.util.Arrays;

public class HammingWeightsOfIntegers {
    public hammingWeightsOfIntegers(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = countSetBits(i);
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
