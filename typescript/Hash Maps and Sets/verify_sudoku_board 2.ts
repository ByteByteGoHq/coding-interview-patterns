function verifySudokuBoard(board: number[][]): boolean {
    // Create hash sets for each row, column, and subgrid to keep 
    // track of numbers previously seen on any given row, column, or 
    // subgrid.
    const rowSets: Set<number>[] = Array.from({ length: 9 }, () => new Set());
    const columnSets: Set<number>[] = Array.from({ length: 9 }, () => new Set());
    const subgridSets: Set<number>[][] = Array.from({ length: 3 }, () => Array.from({ length: 3 }, () => new Set()));
    for (let r = 0; r < 9; r++) {
        for (let c = 0; c < 9; c++) {
            const num = board[r][c];
            if (num === 0) 
                continue;
            // Check if 'num' has been seen in the current row, 
            // column, or subgrid.
            if (rowSets[r].has(num)) 
                return false;
            if (columnSets[c].has(num)) 
                return false;
            if (subgridSets[Math.floor(r / 3)][Math.floor(c / 3)].has(num)) 
                return false;
            // If we passed the above checks, mark this value as seen 
            // by adding it to its corresponding hash sets.
            rowSets[r].add(num);
            columnSets[c].add(num);
            subgridSets[Math.floor(r / 3)][Math.floor(c / 3)].add(num);
        }
    }
    return true;
}