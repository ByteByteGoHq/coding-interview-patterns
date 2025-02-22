public class SumBetweenRange {
    int[] prefixSum;

    public SumBetweenRange(int[] nums) {
        this.prefixSum = new int[nums.length];
        this.prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.prefixSum[i] = this.prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return this.prefixSum[j];
        }
        return this.prefixSum[j] - this.prefixSum[i - 1];
    }
}
