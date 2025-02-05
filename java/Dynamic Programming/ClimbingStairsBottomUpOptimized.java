public record ClimbingStairsBottomUpOptimized() {
    public int climbingStairsBottomUpOptimized(int n) {
        if (n <= 2) {
            return n;
        }
        // Set 'oneStepBefore' and 'twoStepsBefore' as the base cases.
        int oneStepBefore = 2;
        int twoStepsBefore = 1;
        for (int i = 3; i < n + 1; i++) {
            // Calculate the number of ways to reach the current step.
            int current = oneStepBefore + twoStepsBefore;
            // Update the values for the next iteration.
            twoStepsBefore = oneStepBefore;
            oneStepBefore = current;
        }
        return oneStepBefore;
    }
}
