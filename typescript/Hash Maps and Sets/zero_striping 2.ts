function zeroStriping(matrix: number[][]): void {
    if (!matrix || !matrix[0])
        return;
    const m = matrix.length, n = matrix[0].length;
    // Check if the first row initially contains a zero.
    let firstRowHasZero = false;
    for (let c = 0; c < n; c++) {
        if (matrix[0][c] === 0) {
            firstRowHasZero = true;
            break;
        }
    }
    // Check if the first column initially contains a zero.
    let firstColHasZero = false;
    for (let r = 0; r < m; r++) {
        if (matrix[r][0] === 0) {
            firstColHasZero = true;
            break;
        }
    }
    // Use the first row and column as markers. If an element in the
    // submatrix is zero, mark its corresponding row and column in the
    // first row and column as 0.
    for (let r = 1; r < m; r++) {
        for (let c = 1; c < n; c++) {
            if (matrix[r][c] === 0) {
                matrix[0][c] = 0;
                matrix[r][0] = 0;
            }
        }
    }
    // Update the submatrix using the markers in the first row and
    // column.
    for (let r = 1; r < m; r++) {
        for (let c = 1; c < n; c++) {
            if (matrix[0][c] === 0 || matrix[r][0] === 0) {
                matrix[r][c] = 0;
            }
        }
    }
    // If the first row had a zero initially, set all elements in the
    // first row to zero.
    if (firstRowHasZero) {
        for (let c = 0; c < n; c++) {
            matrix[0][c] = 0;
        }
    }
    // If the first column had a zero initially, set all elements in
    // the first column to zero.
    if (firstColHasZero) {
        for (let r = 0; r < m; r++) {
            matrix[r][0] = 0;
        }
    }
}