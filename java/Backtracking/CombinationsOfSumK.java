import java.util.ArrayList;
import java.util.List;

public class CombinationsOfSumK {
    public List<List<Integer>> combinationsOfSumK(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), 0, nums, target, res);
        return res;
    }

    private void dfs(List<Integer> combination, int startIndex, int[] nums, int target, List<List<Integer>> res) {
        // Termination condition: If the target is equal to 0, we found a combination 
        // that sums to 'k'.
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }
        // Termination condition: If the target is less than 0, no more valid 
        // combinations can be created by adding it to the current combination.
        if (target < 0) {
            return;
        }
        // Starting from start_index, explore all combinations after adding nums[i].
        for (int i = startIndex; i < nums.length; i++) {
            // Add the current number to create a new combination.
            combination.add(nums[i]);
            // Recursively explore all paths that branch from this new combination.
            dfs(combination, i, nums, target - nums[i], res);
            // Backtrack by removing the number we just added.
            combination.remove(combination.size() - 1);
        }
    }
}
