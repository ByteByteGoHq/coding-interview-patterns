import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllPermutations {
    public List<List<Integer>> findAllPermutations(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new HashSet<>(), res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> candidate, Set<Integer> used, List<List<Integer>> res) {
        // If the current candidate is a complete permutation, add it to the
        // result.
        if (candidate.size() == nums.length) {
            res.add(new ArrayList<>(candidate));
            return;
        }
        for (int num : nums) {
            if (!used.contains(num)) {
                // Add 'num' to the current permutation and mark it as used.
                candidate.add(num);
                used.add(num);
                // Recursively explore all branches using the updated
                // permutation candidate.
                backtrack(nums, candidate, used, res);
                // Backtrack by reversing the changes made.
                candidate.remove(candidate.size() - 1);
                used.remove(num);
            }
        }
    }
}
