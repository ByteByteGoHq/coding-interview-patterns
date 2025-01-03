package twopointers;

public class NextLexicographicalSequence {
    public String nextLexicographicalSequence(String s) {
        char[] letters = s.toCharArray();
        // Locate the pivot, which is the first character from the right that breaks non-increasing order.
        // Start searching from the second-to-last position.
        int pivot = s.length() - 2;
        while (pivot >= 0 && letters[pivot] >= letters[pivot + 1]) {
            pivot--;
        }
        // If pivot is not found, the string is already in its largest permutation.
        // In this case, reverse the string to obtain the smallest permutation.
        if (pivot == -1) {
            reverseCharArray(letters, 0, letters.length - 1);
            return new String(letters);
        }
        // Find the rightmost successor to the pivot.
        int rightMostSuccessor = s.length() - 1;
        while (letters[rightMostSuccessor] <= letters[pivot]) {
            rightMostSuccessor--;
        }
        // Swap the rightmost successor with the pivot to increase the lexicographical order of the suffix.
        char temp = letters[pivot];
        letters[pivot] = letters[rightMostSuccessor];
        letters[rightMostSuccessor] = temp;

        // Reverse the suffix after the pivot to minimize its permutation.
        reverseCharArray(letters, pivot + 1, letters.length - 1);
        return new String(letters);
    }

    public void reverseCharArray(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }

    // This approach is the way of not converting string `s` into array of chars
    public String nextLexicographicalSequence2(String s) {
        // Locate the pivot, which is the first character from the right that breaks non-increasing order.
        // Start searching from the second-to-last position.
        int pivot = s.length() - 2;
        while (pivot >= 0 && s.charAt(pivot) >= s.charAt(pivot + 1)) {
            pivot--;
        }
        // If pivot is not found, the string is already in its largest permutation.
        // In this case, reverse the string to obtain the smallest permutation.
        if (pivot == -1) {
            return new StringBuilder(s).reverse().toString();
        }
        // Find the rightmost successor to the pivot.
        int rightMostSuccessor = s.length() - 1;
        while (s.charAt(rightMostSuccessor) <= s.charAt(pivot)) {
            rightMostSuccessor--;
        }
        // Swap the rightmost successor with the pivot to increase the lexicographical order of the suffix.
        StringBuilder sb = new StringBuilder(s); // Convert to StringBuilder type for `setCharAt` method to swap
        char temp = s.charAt(pivot);
        sb.setCharAt(pivot, s.charAt(rightMostSuccessor));
        sb.setCharAt(rightMostSuccessor, temp);

        // Convert the prefix (up to pivot) back to a string
        String prefix = sb.substring(0, pivot + 1);

        // Reverse the suffix after the pivot to minimize its permutation.
        // Note: convert to String type for `substring` method
        // Note: convert to StringBuilder type for `reverse` method
        String suffix = new StringBuilder(sb.substring(pivot + 1, s.length())).reverse().toString();

        // Concatenate the prefix and reversed suffix and return
        return prefix + suffix;
    }

    public static void main(String[] args) {
        System.out.println("Tests a string with a single character. Expected result: 'a'. Actual result : " + new NextLexicographicalSequence().nextLexicographicalSequence("a"));
        System.out.println("Tests a string with a repeated character. Expected result: 'aaaa'. Actual result : " + new NextLexicographicalSequence().nextLexicographicalSequence("aaaa"));
        System.out.println("Tests a string with a random pivot character. Expected result: 'ynsdeit'. Actual result : " + new NextLexicographicalSequence().nextLexicographicalSequence("ynitsed"));

        System.out.println("Tests a string with a single character. Expected result: 'a'. Actual result : " + new NextLexicographicalSequence().nextLexicographicalSequence2("a"));
        System.out.println("Tests a string with a repeated character. Expected result: 'aaaa'. Actual result : " + new NextLexicographicalSequence().nextLexicographicalSequence2("aaaa"));
        System.out.println("Tests a string with a random pivot character. Expected result: 'ynsdeit'. Actual result : " + new NextLexicographicalSequence().nextLexicographicalSequence2("ynitsed"));
    }

}
