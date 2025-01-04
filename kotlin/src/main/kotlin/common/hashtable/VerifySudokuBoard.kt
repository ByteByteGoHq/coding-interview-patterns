package common.hashtable

class VerifySudokuBoard {

    fun solution(board: List<List<Int>>): Boolean {
        // Create hash sets for each row, column, and subgrid to keep
        // track of numbers previously seen on any given row, column, or
        // subgrid.
        val rowSet: List<HashSet<Int>> = List(9) {
            hashSetOf()
        }
        val colSet: List<HashSet<Int>> = List(9) {
            hashSetOf()
        }
        val subBoxSet: List<List<HashSet<Int>>> = List(3) {
            List(3) {
                hashSetOf()
            }
        }
        for (r in 0 until 9) {
            for (c in 0 until 9) {
                val num = board[r][c]
                if (num == 0) {
                    continue
                }
                // Check if 'num' has been seen in the current row,
                // column, or subgrid.
                // Use Java/Kotlin HashSet add to confirm 'num' existing status in set
                if (!rowSet[r].add(num)) {
                    return false
                }
                if (!colSet[c].add(num)) {
                    return false
                }
                if (!subBoxSet[r / 3][c / 3].add(num)) {
                    return false
                }
            }
        }
        return true
    }
}