import java.util.ArrayList;
import java.util.List;

public class FindAllSubsets {
    public List<List<Integer>> findAllSubsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, res);
        return res;
    }

    private void backtrack(int i, List<Integer> currSubset, int[] nums, List<List<Integer>> res) {
        // Base case: if all elements have been considered, add the
        // current subset to the output.
        if (i == nums.length) {
            res.add(new ArrayList<>(currSubset));
            return;
        }
        // Include the current element and recursively explore all paths
        // that branch from this subset.
        currSubset.add(nums[i]);
        backtrack(i + 1, currSubset, nums, res);
        // Exclude the current element and recursively explore all paths
        // that branch from this subset.
        currSubset.remove(currSubset.size() - 1);
        backtrack(i + 1, currSubset, nums, res);
    }
}
