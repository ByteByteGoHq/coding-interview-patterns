func verifySudokuBoard(_ board: [[Int]]) -> Bool {
    /* Create hash sets for each row, column, and subgrid to keep track of numbers previously seen on any given, row, column, or subgrid */

    var rowSets: [Set<Int>] = Array(repeating: Set<Int>(), count: 9)
    var columnSets: [Set<Int>] = Array(repeating: Set<Int>(), count: 9)
    var subgridSets: [[Set<Int>]] = Array(
        repeating: Array(repeating: Set<Int>(), count: 3),
        count: 3
    )
    
    for r in 0..<9 {
        for c in 0..<9 {
            var num = board[r][c]
            
            if num == 0 {
                continue
            }
            
            // Check if 'num' has been seen in the current row, column, or subgrid
            
            if rowSets[r].contains(num) {
                return false
            }
            
            if columnSets[c].contains(num) {
                return false
            }
            
            if subgridSets[r / 3][c / 3].contains(num) {
                return false
            }
            
            // If we passed the above checks, mark this value as seen
            // by adding it to its corresponding hash sets.
            rowSets[r].insert(num)
            columnSets[c].insert(num)
            subgridSets[r / 3][c / 3].insert(num)
        }
    }
    
    return true
}
