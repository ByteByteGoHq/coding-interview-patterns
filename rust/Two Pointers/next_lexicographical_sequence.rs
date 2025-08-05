fn next_lexicographical_sequence(s: &str) -> String {
    let mut letters: Vec<char> = s.chars().collect();

    // Locate the pivot, which is the first character from the right that breaks
    // non-increasing order. Start searching from the second-to-last position.
    let mut pivot = letters.len() - 2;
    while pivot < letters.len() && letters[pivot] >= letters[pivot + 1] {
        if pivot == 0 {
            break;
        }
        pivot -= 1;
    }

    // If pivot is not found, the string is already in its largest permutation. In
    // this case, reverse the string to obtain the smallest permutation.
    if pivot == 0 && letters[pivot] >= letters[pivot + 1] {
        letters.reverse();
        return letters.into_iter().collect();
    }

    // Find the rightmost successor to the pivot.
    let mut rightmost_successor = letters.len() - 1;
    while letters[rightmost_successor] <= letters[pivot] {
        rightmost_successor -= 1;
    }

    // Swap the rightmost successor with the pivot to increase the lexicographical
    // order of the suffix.
    letters.swap(pivot, rightmost_successor);

    // Reverse the suffix after the pivot to minimize its permutation.
    letters[(pivot + 1)..].reverse();

    letters.into_iter().collect()
}
