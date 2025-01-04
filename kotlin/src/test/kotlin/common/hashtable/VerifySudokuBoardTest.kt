package common.hashtable

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class VerifySudokuBoardTest {

    private val question = VerifySudokuBoard()

    @Test
    fun `Test case #1 - Expected True`() {
        val board = listOf(
            listOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
            listOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            listOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            listOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            listOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            listOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            listOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            listOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            listOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        )
        assertTrue { question.solution(board) }
    }

    @Test
    fun `Test case #2 - Expected False`() {
        val board = listOf(
            listOf(8, 3, 0, 0, 7, 0, 0, 0, 0),
            listOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            listOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            listOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            listOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            listOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            listOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            listOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            listOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        )
        assertFalse { question.solution(board) }
    }


    @Test
    fun `Test case #3 - Expected False`() {
        val board = listOf(
            listOf(3, 0, 6, 0, 5, 8, 4, 0, 0),
            listOf(5, 2, 0, 0, 0, 0, 0, 0, 0),
            listOf(0, 8, 7, 0, 0, 0, 0, 3, 1),
            listOf(1, 0, 2, 5, 0, 0, 3, 2, 0),
            listOf(9, 0, 0, 8, 6, 3, 0, 0, 5),
            listOf(0, 5, 0, 0, 9, 0, 6, 0, 0),
            listOf(0, 3, 0, 0, 0, 8, 2, 5, 0),
            listOf(0, 1, 0, 0, 0, 0, 0, 7, 4),
            listOf(0, 0, 5, 2, 0, 6, 0, 0, 0)
        )
        assertFalse { question.solution(board) }
    }
}