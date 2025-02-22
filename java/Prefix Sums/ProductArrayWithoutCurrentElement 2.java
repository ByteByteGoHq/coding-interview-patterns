import java.util.Arrays;

public class ProductArrayWithoutCurrentElement {
    public int[] productArrayWithoutCurrentElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        // Populate the output with the running left product.
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // Multiply the output with the running right product, from right to 
        // left.
        int rightProduct = 1;
        for (int i = n - 1; i > -1; i--) {
            res[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return res;
    }
}
