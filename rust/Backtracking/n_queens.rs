use std::collections::HashSet;

fn dfs(
    row: i32,
    cols: &mut HashSet<i32>,
    diagonals: &mut HashSet<i32>,
    anti_diagonals: &mut HashSet<i32>,
    n: i32,
    count: &mut i32,
) {
    // If we reach the end, all queens are placed successfully
    if row == n {
        *count += 1;
        return;
    }

    for col in 0..n {
        let diag = row - col;
        let anti_diag = row + col;

        // Check if the position is safe
        if cols.contains(&col) || diagonals.contains(&diag) || anti_diagonals.contains(&anti_diag) {
            continue;
        }

        // Choose: place the queen
        cols.insert(col);
        diagonals.insert(diag);
        anti_diagonals.insert(anti_diag);

        // Explore
        dfs(row + 1, cols, diagonals, anti_diagonals, n, count);

        // Unchoose (backtrack): remove the queen
        cols.remove(&col);
        diagonals.remove(&diag);
        anti_diagonals.remove(&anti_diag);
    }
}

fn n_queens(n: i32) -> i32 {
    let mut cols = HashSet::new();
    let mut diagonals = HashSet::new();
    let mut anti_diagonals = HashSet::new();
    let mut count = 0;

    dfs(
        0,
        &mut cols,
        &mut diagonals,
        &mut anti_diagonals,
        n,
        &mut count,
    );

    count
}
