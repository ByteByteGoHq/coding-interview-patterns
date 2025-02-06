public class JumpToTheEnd {
    public boolean jumpToTheEnd(int[] nums) {
        // Set the initial destination to the last index in the array.
        int destination = nums.length - 1;
        // Traverse the array in reverse to see if the destination can be 
        // reached by earlier indexes.
        for (int i = nums.length - 1; i >= 0; i--) {
            // If we can reach the destination from the current index,
            // set this index as the new destination.
            if (i + nums[i] >= destination) {
                destination = i;
            }
        }
        // If the destination is index 0, we can jump to the end from index 
        // 0.
        return destination == 0;
    }
}
