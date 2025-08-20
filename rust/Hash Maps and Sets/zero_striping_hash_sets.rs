use std::collections::HashSet;

pub fn zero_striping_hash_sets(matrix: &mut Vec<Vec<i32>>) {
    if matrix.is_empty() || matrix[0].is_empty() {
        return;
    }

    let m = matrix.len();
    let n = matrix[0].len();
    let mut zero_rows = HashSet::new();
    let mut zero_cols = HashSet::new();

    // Pass 1: Traverse through the matrix to identify the rows and
    // columns containing zeros and store their indexes in the
    // appropriate hash sets.
    for r in 0..m {
        for c in 0..n {
            if matrix[r][c] == 0 {
                zero_rows.insert(r);
                zero_cols.insert(c);
            }
        }
    }

    // Pass 2: Set any cell in the matrix to zero if its row index is
    // in 'zero_rows' or its column index is in 'zero_cols'.
    for r in 0..m {
        for c in 0..n {
            if zero_rows.contains(&r) || zero_cols.contains(&c) {
                matrix[r][c] = 0;
            }
        }
    }
}
