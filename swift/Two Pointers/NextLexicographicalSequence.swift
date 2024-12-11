func nextLexicographicalSequence(_ s: String) -> String {
    var letters = Array(s)
    // Locate the pivot, which is the first character from the right that breaks
    // non-increasing order. Start searching from the second-to-last position.
    var pivot = letters.count - 2
    while pivot >= 0 && letters[pivot] >= letters[pivot + 1] {
        pivot -= 1
    }
    // If pivot is not found, the string is already in its largest permutation. In
    // this case, reverse the string to obtain the smallest permutation.
    if pivot == -1 {
        return String(letters.reversed())
    }
    // Find the rightmost successor to the pivot.
    var rightmostSuccessor = letters.count - 1
    while letters[rightmostSuccessor] <= letters[pivot] {
        rightmostSuccessor -= 1
    }
    // Swap the rightmost successor with the pivot to increase the lexicographical
    // order of the suffix.
    letters.swapAt(rightmostSuccessor, pivot)
    // Reverse the suffix after the pivot to minimize its permutation.
    letters.replaceSubrange((pivot + 1)..., with: letters[(pivot + 1)...].reversed())
    return String(letters)
}
