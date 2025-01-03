package twopointers;

public class ShiftZerosToTheEnd {
    public void shiftZerosToTheEnd(int[] nums) {
        // The 'left' pointer is used to position non-zero elements.
        int left = 0;
        // Iterate through the array using a 'right' pointer to locate non-zero elements.
        for (int right = 0; right < nums.length; right++) {
            // If the element at the 'right' pointer is non-zero, swap it with the element at the 'left' pointer.
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                // Increment 'left' since it now points to a position already occupied by a non-zero element.
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{};
        new ShiftZerosToTheEnd().shiftZerosToTheEnd(test1);
        System.out.println("Tests an empty array. Expected output: " + java.util.Arrays.toString(test1));

        int[] test2 = new int[]{0};
        new ShiftZerosToTheEnd().shiftZerosToTheEnd(test2);
        System.out.println("Tests an array with one 0. Expected output: " + java.util.Arrays.toString(test2));

        int[] test3 = new int[]{1};
        new ShiftZerosToTheEnd().shiftZerosToTheEnd(test3);
        System.out.println("Tests an array with one 1. Expected output: " + java.util.Arrays.toString(test3));

        int[] test4 = new int[]{0, 0, 0};
        new ShiftZerosToTheEnd().shiftZerosToTheEnd(test4);
        System.out.println("Tests an array with all 0s. Expected output: " + java.util.Arrays.toString(test4));

        int[] test5 = new int[]{1, 3, 2};
        new ShiftZerosToTheEnd().shiftZerosToTheEnd(test5);
        System.out.println("Tests an array with all non-zeros. Expected output: " + java.util.Arrays.toString(test5));

        int[] test6 = new int[]{1, 1, 1, 0, 0};
        new ShiftZerosToTheEnd().shiftZerosToTheEnd(test6);
        System.out.println("Tests an array with all zeros already at the end. Expected output: " + java.util.Arrays.toString(test6));

        int[] test7 = new int[]{0, 0, 1, 1, 1};
        new ShiftZerosToTheEnd().shiftZerosToTheEnd(test7);
        System.out.println("Tests an array with all zeros at the start. Expected output: " + java.util.Arrays.toString(test7));

    }
}
