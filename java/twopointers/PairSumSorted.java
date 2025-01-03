package twopointers;

import java.util.Arrays;

public class PairSumSorted {
    public int[] pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // If the sum is smaller, increment the left pointer, aiming to increase the sum toward the target value.
            if (sum < target) {
                left++;
            } else if (sum > target) { // If the sum is larger, decrement the right pointer, aiming to decrease the sum toward the target value.
                right--;
            } else { // If the target pair is found, return its indexes.
                return new int[] {left, right};
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        System.out.println("Tests an empty array. Expected output: " + Arrays.toString(new PairSumSorted().pairSumSorted(new int[]{}, 0)));
        System.out.println("Tests an array with one element. Expected output: " + Arrays.toString(new PairSumSorted().pairSumSorted(new int[]{1}, 1)));
        System.out.println("Tests a two-element array that contains a pair that sums to the target. Expected output: " + Arrays.toString(new PairSumSorted().pairSumSorted(new int[]{2, 3}, 5)));
        System.out.println("Tests a two-element array that does not contain a pair that sums to the target. Expected output: " + Arrays.toString(new PairSumSorted().pairSumSorted(new int[]{2, 4}, 5)));
        System.out.println("Tests an array with duplicated values. Expected output: " + Arrays.toString(new PairSumSorted().pairSumSorted(new int[]{2, 2, 3}, 5)));
        System.out.println("Tests if the algorithm works with a negative number in the target pair. Expected output: " + Arrays.toString(new PairSumSorted().pairSumSorted(new int[]{-1, 2, 3}, 2)));
        System.out.println("Tests if the algorithm works with both numbers of the target pair being negative. Expected output: " + Arrays.toString(new PairSumSorted().pairSumSorted(new int[]{-3, -2, -1}, -5)));
    }
}
