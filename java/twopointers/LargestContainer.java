package twopointers;

public class LargestContainer {
    public int largestContainer(int[] height) {
        int maxWater = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            // Calculate the water contained between the current pair of lines.
            int water = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, water);
            // Move the pointers inward, always moving the pointer at the shorter line.
            // If both lines have the same height, move both pointers inward.
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println("Tests an empty array. Expected output: " + new LargestContainer().largestContainer(new int[]{}));
        System.out.println("Tests an array with one element. Expected output: " + new LargestContainer().largestContainer(new int[]{1}));
        System.out.println("Tests an array with no containers that can contain water. Expected output: " + new LargestContainer().largestContainer(new int[]{0, 1, 0}));
        System.out.println("Tests an array with all heights are the same. Expected output: " + new LargestContainer().largestContainer(new int[]{3, 3, 3, 3}));
        System.out.println("Tests an array with strictly increasing heights. Expected output: " + new LargestContainer().largestContainer(new int[]{1, 2, 3}));
        System.out.println("Tests an array with strictly decreasing heights. Expected output: " + new LargestContainer().largestContainer(new int[]{3, 2, 1}));
    }
}
