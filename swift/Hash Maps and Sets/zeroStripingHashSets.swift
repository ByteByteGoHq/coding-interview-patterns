func zeroStripingHastSets(_ matrix: inout [[Int]]) {
    guard !matrix.isEmpty || matrix[0].isEmpty else { return }
    let m = matrix.count
    let n = matrix[0].count
    
    var zeroRows: Set<Int> = []
    var zeroCols: Set<Int> = []
    
    /* Pass 1: Traverse through the matrix to identify the rows and
     columns containing zeros and store their indexes in the
     appropriate hash sets.
     */
    for r in 0..<m {
        for c in 0..<n {
            if matrix[r][c] == 0 {
                zeroRows.insert(r)
                zeroCols.insert(c)
            }
        }
    }
    
    // Pass 2: Set any cell in the matrix to zero if its row index is
    // in 'zero_rows' or its column index is in 'zero_cols'.
    for r in 0..<m {
        for c in 0..<n {
            if zeroRows.contains(r) || zeroCols.contains(c) {
                matrix[r][c] = 0
            }
        }
    }
}
