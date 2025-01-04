package common.twopointers.pairsumsorted

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class PairSumSortedTest {

    private val question = PairSumSorted()

    @Test
    fun `Expected pair is found and valid`() {
        assertAll(
            Executable {
                assertEquals(listOf(2, 3), question.solution(intArrayOf(-5, -2, 3, 4, 6), 7))
            },
            Executable {
                assertEquals(listOf(0, 1), question.solution(intArrayOf(2, 3), 5))
            },
        )
    }

    @Test
    fun `Expected pair is empty`() {
        assertAll(
            Executable {
                assertEquals(emptyList<Int>(), question.solution(intArrayOf(), 0))
            },
            Executable {
                assertEquals(emptyList<Int>(), question.solution(intArrayOf(1), 1))
            },
            Executable {
                assertEquals(emptyList<Int>(), question.solution(intArrayOf(2, 4), 5))
            }
        )
    }

}