func zeroStripingHashSets(matrix [][]int) {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return
	}
	m, n := len(matrix), len(matrix[0])
	zeroRows := make(map[int]struct{})
	zeroCols := make(map[int]struct{})
	// Pass 1: Traverse through the matrix to identify the rows and
	// columns containing zeros and store their indexes in the
	// appropriate hash sets.
	for r := 0; r < m; r++ {
		for c := 0; c < n; c++ {
			if matrix[r][c] == 0 {
				zeroRows[r] = struct{}{}
				zeroCols[c] = struct{}{}
			}
		}
	}
	// Pass 2: Set any cell in the matrix to zero if its row index is
	// in 'zero_rows' or its column index is in 'zero_cols'.
	for r := 0; r < m; r++ {
		for c := 0; c < n; c++ {
			if _, ok := zeroRows[r]; ok {
				matrix[r][c] = 0
			} else if _, ok := zeroCols[c]; ok {
				matrix[r][c] = 0
			}
		}
	}
}
