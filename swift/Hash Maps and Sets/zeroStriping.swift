// function inputs are constant unless you add inout
func zeroStriping(_ matrix: inout [[Int]]) {
    guard !matrix.isEmpty || !matrix[0].isEmpty else { return }

    let m = matrix.count
    let n = matrix[0].count

    // Check if the first row initially contains a zero.
    var firstRowHasZero = false

    for c in 0..<n {
        if matrix[0][c] == 0 {
            firstRowHasZero = true
            break
        }
    }

    // Check if the first column initially contains a zero.
    var firstColHasZero = false

    for r in 0..<m {
        if matrix[r][0] == 0 {
            firstColHasZero = true
            break
        }
    }

    /* Use the first row and column as markers. If an element in the
     submatrix is zero, mark its corresponding row and column in the
     first row and column as 0.
     */

    for r in 1..<m {
        for c in 1..<n {
            if matrix[r][c] == 0 {
                matrix[0][c] = 0
                matrix[r][0] = 0
            }
        }
    }

    // Update the submatrix using the markers in the first row and column
    for r in 1..<m {
        for c in 1..<n {
            if matrix[0][c] == 0 || matrix[r][0] == 0 {
                matrix[r][c] = 0
            }
        }
    }

    // If the first row had a zero initially, set all elements in the
    // first row to zero.
    if firstRowHasZero {
        for c in 0..<n {
            matrix[0][c] = 0
        }
    }

    // If the first column had a zero initially, set all elements in
    // the first column to zero.
    if firstColHasZero {
        for r in 0..<m {
            matrix[r][0] = 0
        }
    }

}
