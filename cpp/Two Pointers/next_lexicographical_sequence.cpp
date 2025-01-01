#include <algorithm>
#include <string>

std::string nextLexicographicalSequence(std::string s) {
    // Locate the pivot, which is the first character from the right that breaks
    // non-increasing order. Start searching from the second-to-last position.
    int pivot = s.size() - 2;
    while (pivot >= 0 && s[pivot] >= s[pivot + 1]) {
        pivot --;
    }
    // If pivot is not found, the string is already in its largest permutation.
    // In this case, reverse the string to obtain the smallest permutation.
    if (pivot == -1) {
        std::reverse(s.begin(), s.end());
        return s;
    }
    // Find the rightmost successor to the pivot.
    int rightMostSuccessor = s.size() - 1;
    while (s[rightMostSuccessor] <= s[pivot]) {
        rightMostSuccessor--;
    }
    // Swap the rightmost successor with the pivot to increase the lexicographical
    // order of the suffix.
    std::swap(s[pivot], s[rightMostSuccessor]);
    // Reverse the suffix after the pivot to minimize its permutation.
    std::reverse(s.begin() + pivot + 1, s.end());
    return s;
}