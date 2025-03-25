pub fn n_queens(n: i32) -> i32 {
    let mut result = 0;
    let mut diagonals_set = std::collections::HashSet::new();
    let mut anti_diagonals_set = std::collections::HashSet::new();
    let mut cols_set = std::collections::HashSet::new();
    
    n_queens_impl(0, &mut diagonals_set, &mut anti_diagonals_set, &mut cols_set, n, &mut result);
    
    result
}

fn n_queens_impl(
    r: i32, 
    diagonals_set: &mut std::collections::HashSet<i32>, 
    anti_diagonals_set: &mut std::collections::HashSet<i32>, 
    cols_set: &mut std::collections::HashSet<i32>, 
    n: i32,
    result: &mut i32
) {
    // Termination condition: If we have reached the end of the rows,
    // we've placed all 'n' queens.
    if r == n {
        *result += 1;
        return;
    }
    
    for c in 0..n {
        let curr_diagonal = r - c;
        let curr_anti_diagonal = r + c;
        
        // If there are queens on the current column, diagonal or
        // anti-diagonal, skip this square.
        if cols_set.contains(&c) || 
           diagonals_set.contains(&curr_diagonal) || 
           anti_diagonals_set.contains(&curr_anti_diagonal) {
            continue;
        }
        
        // Place the queen by marking the current column, diagonal, and
        // anti-diagonal as occupied.
        cols_set.insert(c);
        diagonals_set.insert(curr_diagonal);
        anti_diagonals_set.insert(curr_anti_diagonal);
        
        // Recursively move to the next row to continue placing queens.
        n_queens_impl(r + 1, diagonals_set, anti_diagonals_set, cols_set, n, result);
        
        // Backtrack by removing the current column, diagonal, and
        // anti-diagonal from the hash sets.
        cols_set.remove(&c);
        diagonals_set.remove(&curr_diagonal);
        anti_diagonals_set.remove(&curr_anti_diagonal);
    }
}
