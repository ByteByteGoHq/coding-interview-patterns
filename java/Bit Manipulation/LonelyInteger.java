public class LonelyInteger {
    public int lonelyInteger(int[] nums) {
        int res = 0;
        // XOR each element of the array so that duplicate values will 
        // cancel each other out (x ^ x == 0).
        for (int num : nums) {
            res ^= num;
        }
        // 'res' will store the lonely integer because it would not have 
        // been canceled out by any duplicate.
        return res;
    }
}
