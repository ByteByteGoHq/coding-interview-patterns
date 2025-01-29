package hashmapsandsets

func VerifySudokuBoard(board [][]int) bool {
	// Create hash sets for each row, column, and subgrid to keep
	// track of numbers previously seen on any given row, column, or
	// subgrid.
	rowSets := make([]map[int]struct{}, 9)
	columnSets := make([]map[int]struct{}, 9)
	subgridSets := make([][]map[int]struct{}, 3)

	for i := range rowSets {
		rowSets[i] = make(map[int]struct{})
	}
	for i := range columnSets {
		columnSets[i] = make(map[int]struct{})
	}
	for i := range subgridSets {
		subgridSets[i] = make([]map[int]struct{}, 3)
		for j := range subgridSets[i] {
			subgridSets[i][j] = make(map[int]struct{})
		}
	}

	for r := 0; r < 9; r++ {
		for c := 0; c < 9; c++ {
			num := board[r][c]
			if num == 0 {
				continue
			}
			// Check if 'num' has been seen in the current row,
			// column, or subgrid.
			if _, exists := rowSets[r][num]; exists {
				return false
			}
			if _, exists := columnSets[c][num]; exists {
				return false
			}
			if _, exists := subgridSets[r/3][c/3][num]; exists {
				return false
			}
			// If we passed the above checks, mark this value as seen
			// by adding it to its corresponding hash sets.
			rowSets[r][num] = struct{}{}
			columnSets[c][num] = struct{}{}
			subgridSets[r/3][c/3][num] = struct{}{}
		}
	}
	return true
}
