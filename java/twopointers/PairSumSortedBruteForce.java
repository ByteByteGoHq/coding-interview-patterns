package twopointers;

import java.util.Arrays;

public class PairSumSortedBruteForce {
    public  int[] pairSumSortedBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        System.out.println("Tests an empty array. Expected output: " + Arrays.toString(new PairSumSortedBruteForce().pairSumSortedBruteForce(new int[]{}, 0)));
        System.out.println("Tests an array with one element. Expected output: " + Arrays.toString(new PairSumSortedBruteForce().pairSumSortedBruteForce(new int[]{1}, 1)));
        System.out.println("Tests a two-element array that contains a pair that sums to the target. Expected output: " + Arrays.toString(new PairSumSortedBruteForce().pairSumSortedBruteForce(new int[]{2, 3}, 5)));
        System.out.println("Tests a two-element array that does not contain a pair that sums to the target. Expected output: " + Arrays.toString(new PairSumSortedBruteForce().pairSumSortedBruteForce(new int[]{2, 4}, 5)));
        System.out.println("Tests an array with duplicated values. Expected output: " + Arrays.toString(new PairSumSortedBruteForce().pairSumSortedBruteForce(new int[]{2, 2, 3}, 5)));
        System.out.println("Tests if the algorithm works with a negative number in the target pair. Expected output: " + Arrays.toString(new PairSumSortedBruteForce().pairSumSortedBruteForce(new int[]{-1, 2, 3}, 2)));
        System.out.println("Tests if the algorithm works with both numbers of the target pair being negative. Expected output: " + Arrays.toString(new PairSumSortedBruteForce().pairSumSortedBruteForce(new int[]{-3, -2, -1}, -5)));
    }
}
