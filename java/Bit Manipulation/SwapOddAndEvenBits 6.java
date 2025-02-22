public class SwapOddAndEvenBits {
    public int swapOddAndEvenBits(int n) {
        int evenMask = 0x55555555; // 01010101010101010101010101010101
        int oddMask = 0xAAAAAAAA;  // 10101010101010101010101010101010
        int evenBits = n & evenMask;
        int oddBits = n & oddMask;
        // Shift the even bits to the left, the odd bits to the right, and 
        // merge these shifted values together.
        return (evenBits << 1) | (oddBits >> 1);
    }
}
