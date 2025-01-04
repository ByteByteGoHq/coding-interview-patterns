package common.twopointers.largestcontainer

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LargestContainerNaiveTest {

    private val question = LargestContainerNaive()

    @Test
    fun `Verify solution`() {
        assertEquals(24, question.solution(listOf(2, 7, 8, 3, 7, 6)))
        assertEquals(49, question.solution(listOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
        assertEquals(1, question.solution(listOf(1, 1)))
        assertEquals(0, question.solution(listOf()))
        assertEquals(0, question.solution(listOf(1)))
        assertEquals(0, question.solution(listOf(0, 1, 0)))
        assertEquals(9, question.solution(listOf(3, 3, 3, 3)))
        assertEquals(2, question.solution(listOf(1, 2, 3)))
        assertEquals(2, question.solution(listOf(3, 2, 1)))
    }

}