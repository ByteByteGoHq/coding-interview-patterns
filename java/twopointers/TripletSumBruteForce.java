package twopointers;

import java.util.*;

public class TripletSumBruteForce {
    public List<List<Integer>> tripletSumBruteForce(int[] nums) {
        int n = nums.length;
        // Use a hash set to ensure we don't add duplicate triplets.
        Set<List<Integer>> triplets = new HashSet<>();

        // Iterate through the indexes of all triplets.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Sort the triplet before including it in the hash set.
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }
        // Convert the HashSet to a List of Lists.
        return new ArrayList<>(triplets);
    }

    public static void main(String[] args) {
        System.out.println("Tests an empty array. Expected output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{}));
        System.out.println("Tests a single-element array. Expected output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{0}));
        System.out.println("Tests a two-element array. Expected output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{1, -1}));
        System.out.println("Tests an array where all three of its values are the same. Expected output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{0, 0, 0}));
        System.out.println("Tests an array with no triplets that sum to 0. Expected output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{1, 0, 1}));
        System.out.println("Tests an array with duplicate triplets. Expected output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{0, 0, 1, -1, 1, -1}));
        // Note: Added a new test case that is not present in the book.
        System.out.println("Tests an array with multiple triplets. Expected output: " + new TripletSumBruteForce().tripletSumBruteForce(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
