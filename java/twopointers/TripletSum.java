package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {
    public List<List<Integer>> tripletSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            // Optimization: triplets consisting of only positive numbers will never sum to 0.
            if (nums[i] > 0) {
                break;
            }
            // To avoid duplicate triplets, skip 'a' if it's the same as the previous number.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Find all pairs that sum to a target of '-a' (-nums[i]).
            List<List<Integer>> pairs = pairSumSortedAllPairs(nums, i + 1, -nums[i]);
            for (List<Integer> pair : pairs) {
                // Note: Arrays.asList() creates a fixed-size list by passing the arguments.
                triplets.add(Arrays.asList(nums[i], pair.get(0), pair.get(1)));
            }
        }
        return triplets;
    }

    public List<List<Integer>> pairSumSortedAllPairs(int[] nums, int start, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                pairs.add(Arrays.asList(nums[left], nums[right]));
                left++;
                // To avoid duplicate '[b, c]' pairs, skip 'b' if it's the same as the previous number.
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println("Tests an empty array. Expected output: " + new TripletSum().tripletSum(new int[]{}));
        System.out.println("Tests a single-element array. Expected output: " + new TripletSum().tripletSum(new int[]{0}));
        System.out.println("Tests a two-element array. Expected output: " + new TripletSum().tripletSum(new int[]{1, -1}));
        System.out.println("Tests an array where all three of its values are the same. Expected output: " + new TripletSum().tripletSum(new int[]{0, 0, 0}));
        System.out.println("Tests an array with no triplets that sum to 0. Expected output: " + new TripletSum().tripletSum(new int[]{1, 0, 1}));
        System.out.println("Tests an array with duplicate triplets. Expected output: " + new TripletSum().tripletSum(new int[]{0, 0, 1, -1, 1, -1}));
        // Note: Added a new test case that is not present in the book.
        System.out.println("Tests an array with multiple triplets. Expected output: " + new TripletSum().tripletSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
