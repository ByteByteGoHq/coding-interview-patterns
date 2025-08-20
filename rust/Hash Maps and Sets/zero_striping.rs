pub fn zero_striping(matrix: &mut Vec<Vec<i32>>) {
    if matrix.is_empty() || matrix[0].is_empty() {
        return;
    }

    let m = matrix.len();
    let n = matrix[0].len();

    // Check if the first row initially contains a zero
    let first_row_has_zero = matrix[0].iter().any(|&x| x == 0);

    // Check if the first column initially contains a zero
    let first_col_has_zero = matrix.iter().any(|row| row[0] == 0);

    // Use the first row and column as markers. If an element in the
    // submatrix is zero, mark its corresponding row and column in the
    // first row and column as 0.
    for r in 1..m {
        for c in 1..n {
            if matrix[r][c] == 0 {
                matrix[0][c] = 0;
                matrix[r][0] = 0;
            }
        }
    }

    // Update the submatrix using the markers in the first row and column
    for r in 1..m {
        for c in 1..n {
            if matrix[0][c] == 0 || matrix[r][0] == 0 {
                matrix[r][c] = 0;
            }
        }
    }

    // If the first row had a zero initially, set all elements in the first row to zero
    if first_row_has_zero {
        for c in 0..n {
            matrix[0][c] = 0;
        }
    }

    // If the first column had a zero initially, set all elements in the first column to zero
    if first_col_has_zero {
        for r in 0..m {
            matrix[r][0] = 0;
        }
    }
}
